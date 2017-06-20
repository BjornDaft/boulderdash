package view;


import java.awt.event.KeyEvent;

import controller.IController;
import controller.Order;
import controller.UserOrder;


public class EventPerformer implements IEventPerformer{
	
	private final IController orderPerformer;
	
	public EventPerformer(IController orderPerformer){
		this.orderPerformer = orderPerformer;
	}
	
	private UserOrder keyCodeToUserOrder(int keyCode){
		
		UserOrder userOrder;
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

	@Override
	public void eventPerform(KeyEvent keyCode) {
		
		final UserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
		if (userOrder != null) {
			this.orderPerformer.orderPerform(userOrder);
		}		
	}
}
