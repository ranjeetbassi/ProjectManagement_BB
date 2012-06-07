package mypackage;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.CheckboxField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class settingsDialog extends customDialog implements FieldChangeListener {

	protected CheckboxField loggedon;
	protected ButtonField okbutton;
	protected ButtonField cancelButton;
	protected LabelField statusMessage;
	protected HorizontalFieldManager checkbox;
	protected HorizontalFieldManager button;
	protected HorizontalFieldManager status;
	public settingsDialog(){
		
		loggedon = new CheckboxField("Kept logged on at all times",false);
		okbutton = new ButtonField("Submit",Field.FIELD_HCENTER);
		cancelButton = new ButtonField("Cancel",Field.FIELD_HCENTER);
		statusMessage = new LabelField("");
		checkbox = new HorizontalFieldManager(Manager.FIELD_LEFT);
		checkbox.add(loggedon);
		add(checkbox);
		button = new HorizontalFieldManager(Manager.FIELD_HCENTER);
		button.add(okbutton);
		button.add(cancelButton);
		add(button);
		status = new HorizontalFieldManager(Manager.FIELD_LEFT);
		status.add(statusMessage);
		add(status);
	
	okbutton.setChangeListener(new FieldChangeListener(){
        public void fieldChanged( Field arg0, int arg1 ) {
        	if(loggedon.getChecked()== true)
        	{
        		loggedon.setChecked(true);
        		statusMessage.setText("You have set your log ins to be permanantly on");
        		close();
        	}
        }
    } );
	cancelButton.setChangeListener(new FieldChangeListener(){
        public void fieldChanged( Field arg0, int arg1 ) {
        	loggedon.setChecked(false);
        	close();
        }
    } );
	}
	
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub

	}
	
}
