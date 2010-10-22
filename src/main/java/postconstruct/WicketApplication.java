package postconstruct;

import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 */ 
public class WicketApplication extends WebApplication
{    

	
	/**
     * 
	 */
	public Class getHomePage()
	{
		return HomePage.class;
	}

    @Override
    protected void init() {
        super.init();                  
        this.addPreComponentOnBeforeRenderListener(new PostConstructListener());
    }
}
