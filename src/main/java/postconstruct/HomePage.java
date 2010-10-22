package postconstruct;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(HomePage.class.getName());
	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {

        // Add the simplest type of label

        // TODO Add your page's components here
    }

    @PostConstruct
    public void afterConstructed() {
        logger.info("It works! Adding a label component to the page.");
        add(new Label("message", "If you see this message wicket is properly configured and running"));        
    }
}
