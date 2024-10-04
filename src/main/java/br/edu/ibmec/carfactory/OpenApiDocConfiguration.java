package br.edu.ibmec.carfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiDocConfiguration {
    @Bean
    public OpenAPI swaggerConfiguration() {
        return new OpenAPI()
                   .info(new Info()
                           .title("Fabricante Spring")
                           .contact(new Contact() 
                                        .name("Rafael Cruz")
                                        .email("rafael.cruz@professores.ibmec.edu.br")
                           )
                           .description("Exemplo de criação de API Rest com Springboot") 
                           .version("1.0")
                   );      
    }

}
