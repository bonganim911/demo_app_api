package demo;


import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger
public class SwaggerConfig {
    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig){
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation(){
        return new SwaggerSpringMvcPlugin( this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .includePatterns("/cars.*");
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "This is a car API",
                "This application is for learning purpose",
                "Demo Springboot API terms of service",
                "bonganim911@gmail.com",
                "Bongani API Licence Type",
                "Bongani API Licence URL");
    }
}
