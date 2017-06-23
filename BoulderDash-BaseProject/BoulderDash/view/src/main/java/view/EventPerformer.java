package view;


import java.awt.event.KeyEvent;

import model.IOrderPerformer;
import model.IUserOrder;
import model.Order;


public class EventPerformer implements IEventPerformer{
	
	private final IOrderPerformer orderPerformer;
	
	public EventPerformer(IOrderPerformer orderPerformer){
		this.orderPerformer = orderPerformer;
	}
	
	@Override
	public void eventPerform(KeyEvent keyCode) {
		
		final IUserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
		if (userOrder != null) {
			this.orderPerformer.orderPerform(userOrder);
		}		
	}
	
	private IUserOrder keyCodeToUserOrder(int keyCode){
		
		IUserOrder userOrder;
		switch (keyCode) {
			case KeyEvent.VK_UP:
				userOrder = new UserOrder(Order.UP);
				break;
			case KeyEvent.VK_RIGHT:
				userOrder = new UserOrder(Order.RIGHT);
				break;
			case KeyEvent.VK_DOWN:
				userOrder = new UserOrder(Order.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				userOrder = new UserOrder(Order.LEFT);
				break;
			case KeyEvent.VK_CONTROL:
				userOrder = new UserOrder(Order.PUSH);
				break;
			default:
				userOrder = null;
		}
		return userOrder;
	}


}
