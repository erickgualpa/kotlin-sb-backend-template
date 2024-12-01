package org.egualpam.contexts.template.kotlinsb.helloworld.application.domain

import org.egualpam.contexts.template.kotlinsb.shared.application.domain.DomainEvent
import org.egualpam.contexts.template.kotlinsb.shared.application.domain.DomainEventId
import java.time.Instant

class HelloWorldCreated(id: DomainEventId, occurredOn: Instant, helloWorld: HelloWorld) :
  DomainEvent(id, occurredOn, helloWorld)
