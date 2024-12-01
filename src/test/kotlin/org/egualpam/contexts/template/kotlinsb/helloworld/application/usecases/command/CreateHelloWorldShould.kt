package org.egualpam.contexts.template.kotlinsb.helloworld.application.usecases.command

import org.assertj.core.api.Assertions.assertThat
import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorld
import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorldCreated
import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorldId
import org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out.HelloWorldExists
import org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out.HelloWorldRepository
import org.egualpam.contexts.template.kotlinsb.shared.application.domain.DomainEvent
import org.egualpam.contexts.template.kotlinsb.shared.application.ports.out.EventBus
import org.junit.jupiter.api.Test
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import java.util.UUID.randomUUID

class CreateHelloWorldShould {
  @Test
  fun `create hello world`() {
    val id = randomUUID().toString()

    val helloWorldExists = mock<HelloWorldExists>()
    val repository = mock<HelloWorldRepository>()
    val eventBus = mock<EventBus>()

    val command = CreateHelloWorldCommand(id)
    CreateHelloWorld(helloWorldExists, repository, eventBus).execute(command)

    argumentCaptor<HelloWorld> {
      verify(repository).save(capture())
      val saved = firstValue
      val expected = HelloWorld(
          id = HelloWorldId(id),
      )
      assertThat(saved).isEqualTo(expected)
    }

    argumentCaptor<Set<DomainEvent>> {
      verify(eventBus).publish(capture())
      val published = firstValue
      assertThat(published).hasSize(1).first().satisfies(
          {
            assertThat(it).isInstanceOf(HelloWorldCreated::class.java)
          },
      )
    }
  }

  @Test
  fun `not create hello world when already exists`() {
    val id = randomUUID().toString()

    val helloWorldExists = mock<HelloWorldExists> {
      on {
        with(HelloWorldId(id))
      } doReturn true
    }
    val repository = mock<HelloWorldRepository>()
    val eventBus = mock<EventBus>()

    val command = CreateHelloWorldCommand(id)
    CreateHelloWorld(helloWorldExists, repository, eventBus).execute(command)

    argumentCaptor<HelloWorld> {
      verify(repository, never()).save(capture())
    }

    argumentCaptor<Set<DomainEvent>> {
      verify(eventBus, never()).publish(capture())
    }
  }
}
