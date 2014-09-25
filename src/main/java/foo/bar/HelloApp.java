package foo.bar;

import foo.bar.customer.dao.CustomerDAO;
import foo.bar.customer.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        Customer customer = new Customer("Tara", 52);
        customerDAO.insert(customer);

        Customer customer1 = customerDAO.findByID(1);
        System.out.println(customer1);
    }
}
