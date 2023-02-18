package config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import service.impl.CustomerServiceImpl;

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackageClasses = {CustomerServiceImpl.class})
public class WebRootConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
