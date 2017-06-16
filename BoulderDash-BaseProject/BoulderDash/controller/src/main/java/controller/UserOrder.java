package controller;

public class UserOrder {
	private final Order	order;
	
	public UserOrder(Order order){
		this.order = order;
	}
	

public Order getOrder(){
	return this.order;
	
	}
}
