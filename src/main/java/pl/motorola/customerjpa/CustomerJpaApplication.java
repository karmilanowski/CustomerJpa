package pl.motorola.customerjpa;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.motorola.customerjpa.entity.Customer;
import pl.motorola.customerjpa.entity.Order;
import pl.motorola.customerjpa.repository.CustomerRepository;
import pl.motorola.customerjpa.repository.OrderRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class CustomerJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository, OrderRepository orderRepository) {
        return (args) -> {
            // save a few customers

            customerRepository.save(new Customer("Jack", "Bauer"));
            customerRepository.save(new Customer("Chloe", "O'Brian"));
            customerRepository.save(new Customer("Kim", "Bauer"));
            customerRepository.save(new Customer("David", "Palmer"));
            customerRepository.save(new Customer("Michelle", "Dessler"));
            Customer customer1 = new Customer("Karol", "Milanowski");
            Customer customer2 = new Customer("Paweł", "Kruk");
            Customer customer3 = new Customer("Kamil", "Bełt");
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);

            orderRepository.save(new Order(2.54, LocalDateTime.now(), customer1));
            orderRepository.save(new Order(200.0, LocalDateTime.now(), customer1));
            orderRepository.save(new Order(354.0, LocalDateTime.now(), customer2));
            orderRepository.save(new Order(245.0, LocalDateTime.now(), customer3));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : customerRepository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = customerRepository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            customerRepository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }

}
