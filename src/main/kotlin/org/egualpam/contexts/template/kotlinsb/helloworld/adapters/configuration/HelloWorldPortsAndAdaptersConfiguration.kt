package org.egualpam.contexts.template.kotlinsb.helloworld.adapters.configuration

import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorld
import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorldId
import org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out.HelloWorldExists
import org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out.HelloWorldRepository
import org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out.HelloWorldSearchRepository
import org.egualpam.contexts.template.kotlinsb.helloworld.application.usecases.query.HelloWorldDto
import org.egualpam.contexts.template.kotlinsb.shared.application.domain.DomainEvent
import org.egualpam.contexts.template.kotlinsb.shared.application.ports.out.EventBus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HelloWorldPortsAndAdaptersConfiguration {
  @Bean
  fun helloWorldRepository(): HelloWorldRepository =
      object : HelloWorldRepository {
        override fun find(id: HelloWorldId) = null

        override fun save(helloWorld: HelloWorld) {

        }
      }

  @Bean
  fun helloWorldSearchRepository(): HelloWorldSearchRepository =
      object : HelloWorldSearchRepository {
        override fun search(id: HelloWorldId) = HelloWorldDto(id.value)
      }

  @Bean
  fun helloWorldExists(): HelloWorldExists =
      object : HelloWorldExists {
        override fun with(id: HelloWorldId) = false
      }

  @Bean
  fun eventBus(): EventBus {
    return object : EventBus {
      private val logger: Logger = LoggerFactory.getLogger(this::class.java)
      override fun publish(domainEvents: Set<DomainEvent>) {
        domainEvents.forEach {
          logger.info("Fake publishing of event [${it.javaClass.simpleName}] with id [${it.id().value}]")
        }
      }
    }
  }
}
