package br.com.spring.data.service.utils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public abstract class EntityUtils {

	private static ModelMapper modelMapper;

	static {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	private EntityUtils() {

	}

	public static <T> T map(Class<T> clazz, Object object) {
		if(object == null) {
			return null;
		}
		
		return modelMapper.map(object, clazz);
	}

	public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> clazz) {
		return entityList.stream().map(entity -> map(clazz, entity)).collect(Collectors.toList());
	}
	
	public static <T> void prepareEntityForUpdate(T oldEntity, T updatedEntity) {
		for(Field f: oldEntity.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			String fieldName = f.getName();
				try {
					Field updatedField = updatedEntity.getClass().getDeclaredField(fieldName);
					updatedField.setAccessible(true);
					Object value = updatedField.get(updatedEntity);
					if(value != null) {
						f.set(oldEntity, value);
					}
				} catch (NoSuchFieldException | SecurityException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
		}
//		Stream.of(oldEntity.getClass().getDeclaredFields()).forEach(
//				f -> {
//					f.setAccessible(true);
//					String fieldName = f.getName();
//						Field value;
//						try {
//							value = updatedEntity.getClass().getDeclaredField(fieldName);
//							value.setAccessible(true);
//							f.set(oldEntity, value.get(updatedEntity));
//						} catch (NoSuchFieldException | SecurityException e1) {
//							e1.printStackTrace();
//						} catch (IllegalArgumentException | IllegalAccessException e) {
//							e.printStackTrace();
//						}
//				}
//				);	
	}
}
