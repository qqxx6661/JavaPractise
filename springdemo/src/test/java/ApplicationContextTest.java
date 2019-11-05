import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    @Test
    public void testFactoryBean() {
        String configLocation = "application.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        NewsProvider newsProvider = (NewsProvider) applicationContext.getBean("newsProvider");
        System.out.println(newsProvider.getNews());
        System.out.println(newsProvider.getNews());
    }
}
