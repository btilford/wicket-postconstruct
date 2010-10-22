package postconstruct;

import org.apache.wicket.Component;
import org.apache.wicket.application.IComponentOnBeforeRenderListener;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author btilford
 * Date: Oct 20, 2010
 * Time: 8:36:00 AM
 */
public class PostConstructListener implements
                                   IComponentOnBeforeRenderListener {

    private static final Logger logger = Logger.getLogger(PostConstructListener.class.getName());

    public void onBeforeRender(final Component component) {
        logger.fine("listener fired for component '" + component.getPath() + "'");
        if (!component.hasBeenRendered()) {
            for (Method method : component.getClass().getMethods()) {
                if (Modifier.isPublic(method.getModifiers()) &&
                    method.getAnnotation(PostConstruct.class) != null &&
                    method.getTypeParameters().length == 0) {
                    try {
                        logger.fine("Invoking " + component.getClass().getName() + "#" + method.getName());
                        method.invoke(component);
                    } catch (IllegalAccessException e) {
                        logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
                    } catch (InvocationTargetException e) {
                        logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
                    }
                }
            }
        }

    }

}   
