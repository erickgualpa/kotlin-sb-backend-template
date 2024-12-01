package org.egualpam.contexts.template.kotlinsb.helloworld.application.usecases.command

class CreateHelloWorld {
  fun execute(command: CreateHelloWorldCommand) {
    // TODO: Add aggregate root creation missing code
  }
}

data class CreateHelloWorldCommand(
  val id: String
)
