package org.egualpam.contexts.template.kotlinsb.helloworld.application.usecases.query

import org.assertj.core.api.Assertions.assertThat
import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorldId
import org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out.HelloWorldSearchRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import java.util.UUID.randomUUID

class RetrieveHelloWorldShould {
  @Test
  fun `retrieve hello world`() {
    val id = randomUUID().toString()
    val query = RetrieveHelloWorldQuery(id)
    val helloWorldDto = HelloWorldDto(id)

    val helloWorldSearchRepository = mock<HelloWorldSearchRepository> {
      on {
        search(HelloWorldId(id))
      } doReturn helloWorldDto
    }

    val result = RetrieveHelloWorld(helloWorldSearchRepository).execute(query)

    assertThat(result).isEqualTo(helloWorldDto)
  }
}
