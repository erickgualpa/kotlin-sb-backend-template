package org.egualpam.contexts.template.kotlinsb.e2e

import org.egualpam.contexts.template.kotlinsb.shared.adapters.AbstractIntegrationTest
import org.junit.jupiter.api.Test
import java.util.UUID.randomUUID

class GetHelloWorldFeature : AbstractIntegrationTest() {
  @Test
  fun `get hello world`() {
    val helloWorldId = randomUUID().toString()
    webTestClient.get()
        .uri("/v1/hello-world/{id}", helloWorldId)
        .exchange()
        .expectStatus()
        .isOk
        .expectHeader()
        .contentType("application/json")
        .expectBody()
        .json(
            """
              {
                "id": "$helloWorldId"
              }
            """,
        )
  }
}
