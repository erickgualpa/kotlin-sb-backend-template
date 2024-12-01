package org.egualpam.contexts.template.kotlinsb.shared.adapters.configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAPIConfiguration {
    @Bean
    fun openAPI(): OpenAPI = OpenAPI()
        .info(
            Info().title("Kotlin + Spring Boot backend template"),
        )
}
