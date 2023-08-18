package groupELstupido.sso;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SSOServerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // Register the Spring Config File
    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class[] configClasses = { SSOConfiguration.class };
        return configClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String [] servletMappings= { "/" };
        return servletMappings;
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setMultipartConfig(new MultipartConfigElement(null, 5242880, 10485760, 0));
    }
}
