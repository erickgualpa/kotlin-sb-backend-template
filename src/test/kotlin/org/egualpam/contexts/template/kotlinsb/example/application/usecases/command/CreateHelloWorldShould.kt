package org.egualpam.contexts.template.kotlinsb.example.application.usecases.command

import org.junit.jupiter.api.Test
import java.util.UUID.randomUUID

class CreateHelloWorldShould {
  @Test
  fun `create hello world`() {
    val id = randomUUID().toString()
    val command = CreateHelloWorldCommand(id)
    CreateHelloWorld().execute(command)
  }
}
