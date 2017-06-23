package view;


import java.awt.event.KeyEvent;

import model.IOrderPerformer;
import model.IUserOrder;
import model.Order;


public class EventPerformer implements IEventPerformer{
	
	 
	private final IOrderPerformer orderPerformer;
	/**
	 *  instantiate EventPerformer
	 * @param orderPerformer
	 */
	public EventPerformer(IOrderPerformer orderPerformer){
		this.orderPerformer = orderPerformer;
	}
	/**
	 * instantiate userOrder with the keycode with new order, if no key pressed return nothing
	 */
	@Override
	public void eventPerform(KeyEvent keyCode) {
		
		final IUserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
		if (userOrder != null) {
			this.orderPerformer.orderPerform(userOrder);
		}		
	}
	/**
	 * Convert the keycode number from user to a object Order
	 * @param keyCode int who represent the number of a key
	 * @return
	 */
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
