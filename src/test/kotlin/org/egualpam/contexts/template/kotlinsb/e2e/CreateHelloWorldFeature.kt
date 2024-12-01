package org.egualpam.contexts.template.kotlinsb.e2e

import org.egualpam.contexts.template.kotlinsb.shared.adapters.AbstractIntegrationTest
import org.junit.jupiter.api.Test
import java.util.UUID.randomUUID

class CreateHelloWorldFeature : AbstractIntegrationTest() {
  @Test
  fun `create hello world`() {
    val helloWorldId = randomUUID().toString()
    webTestClient.put()
        .uri("/v1/hello-world/{id}", helloWorldId)
        .exchange()
        .expectStatus()
        .isNoContent
  }
}
