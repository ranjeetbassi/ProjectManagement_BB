package mypackage;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.container.VerticalFieldManager;

public abstract class customDialog extends Screen implements
		FieldChangeListener {
	public customDialog()
	{
		super(new VerticalFieldManager(),Screen.DEFAULT_CLOSE);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub

	}

	protected void sublayout(int width, int height) {
		// TODO Auto-generated method stub
		layoutDelegate(width - 80, height - 80);
		setPositionDelegate(10, 10);
		setExtent(width - 60, Math.min(height - 60, getDelegate().getHeight() + 20));
		setPosition(30, (height - getHeight())/2);
	}
	protected void paintBackground(Graphics graphics)
	{
		graphics.setColor(0x999966);
		graphics.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
		graphics.setColor(Color.BLACK);
		graphics.drawRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
	}

}
