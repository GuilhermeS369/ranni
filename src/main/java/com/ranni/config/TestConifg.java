package com.ranni.config;

import java.time.Instant;
import java.util.Arrays;

import com.ranni.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ranni.entities.Category;
import com.ranni.entities.Order;
import com.ranni.entities.OrderItem;
import com.ranni.entities.Payment;
import com.ranni.entities.Product;
import com.ranni.entities.User;
import com.ranni.entities.enums.OrderStatus;
import com.ranni.respositories.CategoryRepository;
import com.ranni.respositories.OrderItemRepository;
import com.ranni.respositories.OrderRepository;
import com.ranni.respositories.ProductRepository;
import com.ranni.respositories.UserRepository;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("dev")
@EnableSwagger2
public class TestConifg implements CommandLineRunner {
	//INJEÇÃO DE INDEPENDENCIA
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private UserService userService;

	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
				
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5))
		
;		User u1 = new User(null, "Maria Brown","maria123", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green","verde123", "alex@gmail.com", "977777777", "123456");
		u1.getRoles().add("managers");
		u2.getRoles().add("users");

		userService.insert(u1);
		userService.insert(u2);



		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null,Instant.parse("2019-06-20T21:53:07Z"), o1);		
		o1.setPayment(pay1);
		
		orderRepository.save(o1);

	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ranni.resources"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(buildApiInfo());

	}

	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder()
				.title("API RANNI")
				.description("Api do projeto Ranni, controle de pedidos, com status e produtos")
				.version("0.1")
				.contact(new Contact("Guilherme",
						"https://github.com/GuilhermeS369",
						"Whatsapp: 11 963495981"))
				.build();

	}
}	
