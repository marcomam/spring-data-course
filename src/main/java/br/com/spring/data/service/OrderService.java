package br.com.spring.data.service;

import br.com.spring.data.entity.Order;
import br.com.spring.data.entity.OrderItem;
import br.com.spring.data.service.base.CrudService;

public interface OrderService extends CrudService<Order>{
	Order addOrderItem(Integer orderId, OrderItem orderItem);
	
	Order removeOrderItem(Integer orderId, Integer itemProductId);

	Order closeOrder(Integer id);
}
