import bean.User;
import config.RootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(RootConfig.class);

    public static void main(String[] args) {
        String hello = (String) APPLICATION_CONTEXT.getBean("hello");
        User user = (User) APPLICATION_CONTEXT.getBean("user");
        System.out.println(hello);
        user.setName("Ivan");
        System.out.println(user.getName());
    }
}
