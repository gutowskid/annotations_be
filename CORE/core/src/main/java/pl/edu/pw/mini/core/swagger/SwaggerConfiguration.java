package pl.edu.pw.mini.core.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${pl.edu.pw.mini.swagger.dev-token}")
    private String devToken;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(Collections.singletonList((new ParameterBuilder()
                        .name("X-AUTH-TOKEN")
                        .description("Token autoryzacyjny")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(false)
                        .defaultValue(devToken)
                        .build())))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
