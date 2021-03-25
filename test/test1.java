import com.theoldzheng.aopAnno.User;
import com.theoldzheng.aopXml.Book;
import com.theoldzheng.config.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.25 13:10
 */
public class test1 {
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("hello1.xml");
        User user = applicationContext.getBean("user", User.class);
        user.add();
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("hello2.xml");
        Book book1 = context.getBean("book1", Book.class);
        book1.buyBook();
    }

    @Test
    public void test03(){
        Class [] clazz = {com.theoldzheng.config.aopConfig.class};
        ApplicationContext context = new AnnotationConfigApplicationContext(clazz);
        Person person = context.getBean("person", Person.class);
        person.add();
    }


}
