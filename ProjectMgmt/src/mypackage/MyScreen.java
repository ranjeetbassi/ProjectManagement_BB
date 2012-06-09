package mypackage;



import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.FlowFieldManager;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.Background;
import net.rim.device.api.ui.decor.BackgroundFactory;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class MyScreen extends MainScreen
{
    
	
	/**
     * Creates a new MyScreen object
     */
    public MyScreen()
    {        
        // Set the displayed title of the screen       
        //setTitle("JetPro Tracker");

        LabelField maintitle = new LabelField("JetPro Tracker"){
        	protected void Paint( Graphics graphics){
        		
        		graphics.setColor(Color.WHITE);
        		super.paint(graphics);
        	}
        };
        //Setting the name title of the app 
        try{
        FontFamily titlefamily = FontFamily.forName("Arial");
        Font titlefont = titlefamily.getFont(Font.BOLD, 35);
        maintitle.setFont(titlefont);
        }catch(ClassNotFoundException ex){
        Dialog.alert(" different font");
        }
    	HorizontalFieldManager mainManager = new HorizontalFieldManager(Field.USE_ALL_WIDTH);
    	Background bluebBackground = BackgroundFactory.createSolidBackground(Color.BLUE);
    	mainManager.setBackground(bluebBackground);
    	mainManager.add(maintitle);
        add(mainManager);
        //setting the separatorfield
        add(new SeparatorField());
        //setting the main buttons to either login or settings
        HorizontalFieldManager mainButton = new HorizontalFieldManager(Manager.FIELD_RIGHT);
        final ButtonField register = new ButtonField("Register",Field.FIELD_RIGHT);
        final ButtonField login = new ButtonField("Register/Login",Field.FIELD_RIGHT);
        ButtonField settings = new ButtonField("Settings",Field.FIELD_RIGHT);
        mainButton.add(register);
        mainButton.add(login);
        mainButton.add(settings);
        add(mainButton);
        //setting the separatorfield
        add(new SeparatorField());
        //setting the buttons for view projects, options and help
    	ButtonField viewProjects = new ButtonField("View Existing Projects",Field.FIELD_HCENTER);
    	ButtonField options = new ButtonField("Create New Project",Field.FIELD_HCENTER);
    	ButtonField help = new ButtonField("Help",Field.FIELD_HCENTER);
    	ButtonField exit =  new ButtonField("Exit",Field.FIELD_HCENTER);
    	VerticalFieldManager centerButton= new VerticalFieldManager(Manager.FIELD_HCENTER);
    	centerButton.add(viewProjects);
    	centerButton.add(options);
    	centerButton.add(help);
    	centerButton.add(exit);
    	add(centerButton);
    	//setting the separatorfield
    	add(new SeparatorField());
    	//setting the copyright labelfield.
    	HorizontalFieldManager bottomText = new HorizontalFieldManager(Manager.DOWNWARD);
        LabelField copyright = new LabelField("Copyright @ 2012",Manager.DOWNWARD);
        bottomText.add(copyright);
        add(bottomText);
    
	    login.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	loginDialog newscreen = new loginDialog();
	        	UiApplication.getUiApplication().pushModalScreen(newscreen);
	        	if(newscreen.getcheckscreen()==1)
	        	{
	        		login.setLabel("Log out");
	        	}
	        	register.setVisualState(VISUAL_STATE_DISABLED_FOCUS);

	        }
	    } );
	    register.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	registerDialog newscreen = new registerDialog();
	        	UiApplication.getUiApplication().pushModalScreen(newscreen);
	        	
	        }
	    } );
	    settings.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	settingsDialog newscreen = new settingsDialog();
	        	UiApplication.getUiApplication().pushModalScreen(newscreen);	        	
	        	
	        }
	    } );
	    options.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	optionsDialog newscreen = new optionsDialog();
	        	UiApplication.getUiApplication().pushModalScreen(newscreen);	        	
	        	
	        }
	    } );
	    help.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	helpDialog newscreen = new helpDialog();
	        	UiApplication.getUiApplication().pushModalScreen(newscreen);	        	
	        	
	        }
	    } );
	    exit.setChangeListener(new FieldChangeListener(){
	        public void fieldChanged( Field arg0, int arg1 ) {
	        	System.exit(0);
	        	      	
	        }
	    } );
    }
}
