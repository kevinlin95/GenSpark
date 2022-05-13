package JavaConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "JavaConfiguration")
// Either use getNoun()/@Bean or Component Scan.
public class AppConfig {

    @Bean
    public Address getAddress(){
        return new Address("New York City","New York","US","11111");
    }
    @Bean
    public Phone getPhone(){
        return new Phone(12345,"Admin");
    }
    @Bean
    public Student getStudent() {
        return new Student(getAddress(), getPhone());
    }

}
