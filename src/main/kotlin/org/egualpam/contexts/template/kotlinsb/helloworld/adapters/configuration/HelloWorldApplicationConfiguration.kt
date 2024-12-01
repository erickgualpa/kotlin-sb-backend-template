package org.egualpam.contexts.template.kotlinsb.helloworld.adapters.configuration

import org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out.HelloWorldSearchRepository
import org.egualpam.contexts.template.kotlinsb.helloworld.application.usecases.command.CreateHelloWorld
import org.egualpam.contexts.template.kotlinsb.helloworld.application.usecases.query.RetrieveHelloWorld
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
