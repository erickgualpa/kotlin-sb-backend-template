package org.egualpam.contexts.template.kotlinsb.helloworld.application.usecases.command

import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorld
import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorldId
import org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out.HelloWorldExists
import org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out.HelloWorldRepository
import org.egualpam.contexts.template.kotlinsb.shared.application.ports.out.EventBus

class CreateHelloWorld(
  private val helloWorldExists: HelloWorldExists,
  private val repository: HelloWorldRepository,
  private val eventBus: EventBus
) {
  fun execute(command: CreateHelloWorldCommand) {
    val id = command.id
    val helloWorldId = HelloWorldId(id)

    if (helloWorldExists.with(helloWorldId)) {
      return
    }

    val helloWorld = HelloWorld.create(id)
    repository.save(helloWorld)

    val domainEvents = helloWorld.pullDomainEvents()
    eventBus.publish(domainEvents)
  }
}

data class CreateHelloWorldCommand(
  val id: String
)
