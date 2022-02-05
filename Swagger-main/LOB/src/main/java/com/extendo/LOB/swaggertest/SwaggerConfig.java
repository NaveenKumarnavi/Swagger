package com.extendo.LOB.swaggertest;


//import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import javax.management.QueryExp;

//import static javax.management.Query.or;
//import static jdk.internal.joptsimple.util.RegexMatcher.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.extendo.LOB"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
               // .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private ApiInfo metaData() {
        return  new ApiInfoBuilder()
                .title("LOB API")
                .description("LOB API reference for developers")
                .version("1.1.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("LOB","https://www.google.com/UCMpJ8m1w9t7","javadeveloper.ja@gmail.com"))
                .build();
    }
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}

