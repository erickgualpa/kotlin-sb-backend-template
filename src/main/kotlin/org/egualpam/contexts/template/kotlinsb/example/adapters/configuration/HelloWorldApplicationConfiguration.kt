package org.egualpam.contexts.template.kotlinsb.example.adapters.configuration

import org.egualpam.contexts.template.kotlinsb.example.application.ports.out.HelloWorldSearchRepository
import org.egualpam.contexts.template.kotlinsb.example.application.usecases.command.CreateHelloWorld
import org.egualpam.contexts.template.kotlinsb.example.application.usecases.query.RetrieveHelloWorld
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HelloWorldApplicationConfiguration {
  @Bean
  fun createHelloWorld() = CreateHelloWorld()

  @Bean
  fun retrieveHelloWorld(helloWorldSearchRepository: HelloWorldSearchRepository) =
      RetrieveHelloWorld(helloWorldSearchRepository)
}
