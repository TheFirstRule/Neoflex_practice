package Yashchenko.Dictionary.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "API Web приложения",
                description = "Сделано в качестве проекта по летней практике", version = "1.0.0",
                contact = @Contact(
                        name = "Ященко Никита",
                        email = "NikeYash@mail.ru",
                        url = ""
                )
        )
)
public class OpenApiConfig {

}
