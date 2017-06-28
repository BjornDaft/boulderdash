package controller;

import java.awt.event.KeyEvent;

public interface IEventPerformer {
	public void eventPerform(KeyEvent keyCode);
	public IUserOrder keyTyped(final int keyCode);
}
