package br.com.spring.data.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.spring.data.entity.Merchant;
import br.com.spring.data.repository.MerchantRepository;
import br.com.spring.data.service.MerchantService;
import br.com.spring.data.service.utils.EntityUtils;

@Service
public class MerchantServiceImpl implements MerchantService {
	
	@Autowired
	private MerchantRepository merchantRepository;

	@Override
	public Merchant create(Merchant obj) {
		obj.setCreatedAt(LocalDateTime.now());
		return merchantRepository.save(obj);
	}

	@Override
	public Merchant update(Merchant obj) {
		if(obj.getId() != null) {
			Merchant merchantToUpdate = findById(obj.getId());
			EntityUtils.prepareEntityForUpdate(merchantToUpdate, obj);
			return merchantRepository.save(merchantToUpdate);
		}
		throw new ResourceNotFoundException("Merchant");
	}

	@Override
	public Merchant findById(Integer id) {
		Optional<Merchant> merchantOpt = merchantRepository.findById(id);
		
		if(!merchantOpt.isPresent()) {
			throw new ResourceNotFoundException("Merchant");
		}
		
		return merchantOpt.get();
	}

	@Override
	public List<Merchant> findAll() {
		return merchantRepository.findAll();
	}
	
	@Override
	public void deleteById(Integer id) {
		merchantRepository.deleteById(id);
	}
}
