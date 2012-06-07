package mypackage;
// this is not an options screen , it is actually a creation of a new project
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.DateField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class optionsDialog extends customDialog implements FieldChangeListener {

	protected LabelField projectName;
	protected TextField enterProject;
	protected HorizontalFieldManager projectgroup;
	protected ButtonField okbutton;
	protected ButtonField cancelButton;
	protected HorizontalFieldManager button;
	protected DateField startdate;
	protected DateField enddate;
	protected VerticalFieldManager DateGroup;
	
	public optionsDialog()
	{
		startdate = new DateField("Start Date",System.currentTimeMillis(),DateField.DATE_TIME);
		enddate = new DateField("End Date",System.currentTimeMillis(),DateField.DATE_TIME);
		DateGroup = new VerticalFieldManager(Manager.FIELD_HCENTER);
		DateGroup.add(startdate);
		DateGroup.add(enddate);
		projectName = new LabelField("Enter Project Name: ",Field.FIELD_LEFT);
		enterProject = new TextField();
		okbutton = new ButtonField("Submit",Field.FIELD_HCENTER);
		cancelButton = new ButtonField("Cancel",Field.FIELD_HCENTER);
		projectgroup = new HorizontalFieldManager(Manager.FIELD_LEFT);
		projectgroup.add(projectName);
		projectgroup.add(enterProject);
		add(projectgroup);
		add(DateGroup);
		button = new HorizontalFieldManager(Manager.FIELD_HCENTER);
		button.add(okbutton);
		button.add(cancelButton);
		add(button);
		okbutton.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	Dialog.alert("You have inserted a new project");
	        	close();
	        }
	    } );
		cancelButton.setChangeListener(new FieldChangeListener(){
			public void fieldChanged( Field arg0, int arg1 ) {
	        	close();
	        }
	    } );
	}
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub

	}

	
}
