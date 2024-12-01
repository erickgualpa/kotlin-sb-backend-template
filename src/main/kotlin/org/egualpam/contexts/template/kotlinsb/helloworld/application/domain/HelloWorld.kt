package org.egualpam.contexts.template.kotlinsb.helloworld.application.domain

import org.egualpam.contexts.template.kotlinsb.shared.application.domain.AggregateRoot
import org.egualpam.contexts.template.kotlinsb.shared.application.domain.DomainEventId
import java.time.Instant

class HelloWorld(id: HelloWorldId) : AggregateRoot(id) {
  companion object {
    fun create(id: String): HelloWorld {
      val helloWorld = HelloWorld(
          id = HelloWorldId(id),
      )
      val helloWorldCreated = HelloWorldCreated(
          id = DomainEventId.generate(),
          occurredOn = Instant.now(),
          helloWorld,
      )
      helloWorld.addDomainEvent(helloWorldCreated)
      return helloWorld
    }
  }
}
