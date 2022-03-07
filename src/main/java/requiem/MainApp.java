package requiem;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import requiem.controller.UserController;

public class MainApp {
    //此处不能使用psvm，统一使用注解，否则无法运行
//    @Test
//    public void test(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
//        UserController userController = (UserController) context.getBean("userController");
//        userController.login();
//    }
}
