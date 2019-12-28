import bean.Auditorium;
import bean.Booking;
import bean.Event;
import bean.User;
import config.RootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(RootConfig.class);

    public static void main(String[] args) {
        String hello = (String) APPLICATION_CONTEXT.getBean("hello");
        User user = (User) APPLICATION_CONTEXT.getBean("user");
        Auditorium auditorium = (Auditorium) APPLICATION_CONTEXT.getBean("auditorium");
        Event event = (Event) APPLICATION_CONTEXT.getBean("event");
        Booking booking = (Booking) APPLICATION_CONTEXT.getBean("booking");
        System.out.println(hello);
        user.setName("Ivan");
        System.out.println(user.getName());
    }
}
