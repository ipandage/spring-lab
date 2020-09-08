package AspectJAOP;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Services.IAOPServices;

public class App {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        BeanFactory factory = context;
        IAOPServices services = (IAOPServices) context.getBean("serviceImplA");
        services.withAopMethod();
        services.withNoAopMethod();
    }
}
