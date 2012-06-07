package mypackage;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.util.StringComparator;

public class loginDialog extends customDialog implements FieldChangeListener,loginAttempts {

	protected LabelField username;
	protected LabelField password;
	protected TextField enterUsername;
	protected PasswordEditField enterPassword;
	protected HorizontalFieldManager UsernameManager;
	protected HorizontalFieldManager PasswordManager;
	protected ButtonField okbutton;
	protected ButtonField cancelbutton;
	protected HorizontalFieldManager ButtonManager;
	private int counter=0;
	static int tries = 0;
	public loginDialog()
	{
		username= new LabelField("Username:");
		password = new LabelField("Password:");
		enterUsername = new TextField();
		enterPassword = new PasswordEditField();
		UsernameManager = new HorizontalFieldManager(Manager.FIELD_LEFT);
		PasswordManager = new HorizontalFieldManager(Manager.FIELD_LEFT);
		
		UsernameManager.add(username);
		UsernameManager.add(enterUsername);
		add(UsernameManager);
		PasswordManager.add(password);
		PasswordManager.add(enterPassword);
		add(PasswordManager);
		
		okbutton = new ButtonField("Submit");
		cancelbutton = new ButtonField("Cancel");
		ButtonManager = new HorizontalFieldManager(Manager.FIELD_HCENTER);
		ButtonManager.add(okbutton);
		ButtonManager.add(cancelbutton);
		add(ButtonManager);
		
		okbutton.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	String getUsername = enterUsername.toString();
	        	String getPassword = enterPassword.toString();
	        	String compareWith = "ranjeetbassi";
	        	
	        	if(getUsername.compareTo("ranjeetbassi")==0 && getPassword.compareTo("1234567")==0)
	        	{
	        		setcheckscreen(1);
	        		close();
	        	}
	        	else
	        	{
	        		Dialog.alert("You have entered invalid creditionals. Please retype again.");
	        		enterUsername.setText("");
	        		enterPassword.setText("");
	        		tries++;
	        		checkLoginAttempts(tries);
	        	}
	        }
	    } );
		cancelbutton.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        
	        	close();
	        }
	    } );
	}
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub

	}
	public int getcheckscreen()
	{
		return counter ;
	}
	public void setcheckscreen(int counternew)
	{
		counter = counternew;
	}
	
	public void checkLoginAttempts(int tries) {
		// TODO Auto-generated method stub
		if(tries > login)
		{
			Dialog.alert("You have written a maximum number of time to write your username and password.");
			System.exit(0);
		}
	}
}
