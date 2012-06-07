package mypackage;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.ChoiceField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ObjectChoiceField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class helpDialog extends customDialog implements FieldChangeListener {

	protected LabelField mainHelp;
	protected ButtonField goBack;
	protected VerticalFieldManager buttonGroup;
	protected HorizontalFieldManager Listofhelpoptions;
	String choice[] = { " View Existing Projects","Create New Projects","Settings"};
	protected ChoiceField DropDownMenu;
	protected ButtonField helpforview;
	protected ButtonField helpforcreate;
	protected ButtonField helpforsettings;
	public helpDialog()
	{
		DropDownMenu = new ObjectChoiceField("Select a help topic",choice);
		mainHelp = new LabelField("Please Select a topic of list from the following drop down list");
		goBack = new ButtonField("Go Back",Field.FIELD_VCENTER);
		
		//helpforview = new ButtonField("View Existing Projects",Field.FIELD_VCENTER);
		//helpforcreate = new ButtonField("Create New Projects",Field.FIELD_VCENTER);
		//helpforsettings = new ButtonField("Settings",Field.FIELD_VCENTER);
		
		Listofhelpoptions = new HorizontalFieldManager(Manager.FIELD_HCENTER);
		Listofhelpoptions.add(DropDownMenu);
		add(Listofhelpoptions);
		
		buttonGroup = new VerticalFieldManager(Manager.FIELD_HCENTER);
		//buttonGroup.add(helpforview);
		//buttonGroup.add(helpforcreate);
		//buttonGroup.add(helpforsettings);
		buttonGroup.add(goBack);
		add(buttonGroup);
		goBack.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	close();
	        }
	    } );
		
		DropDownMenu.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	int selectchoice = DropDownMenu.getSelectedIndex();

	        	if(selectchoice== 0)
	        	{
	        		
	        		Dialog.alert("Select a project from the drop down list to see the status of the project");
	        		
	        	}
	        	else if(selectchoice== 1)
	        	{
	        		
	        		Dialog.alert("To create a project, you will need to input your name of your project");
	        		
	        	}
	        	else if(selectchoice==2)
	        	{
	        		
	        		Dialog.alert("You can permantly log in to JetPro Tracker with any further logins again");
	        		
	        	}
	        	
	        	/*
	        	else{
	        		Dialog.alert("You did not select a help item");
	        	}
	        	*/
	        }
	    } );
	    /*
		helpforview.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	Dialog.alert("Select a project from the drop down list to see the status of the project");
	        }
	    } );
		helpforcreate.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	Dialog.alert("To create a project, you will need to input your name of your project");
	        }
	    } );
		helpforsettings.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	Dialog.alert("You can permantly log in to JetPro Tracker with any further logins again");
	        }
	    } );
	    */
	}

}
