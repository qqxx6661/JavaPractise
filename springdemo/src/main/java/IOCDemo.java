import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IOCService;

public class IOCDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        IOCService iocService=context.getBean(IOCService.class);
        System.out.println(iocService.hollo());
    }
}
