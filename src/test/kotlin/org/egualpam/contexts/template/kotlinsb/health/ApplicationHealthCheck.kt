package org.egualpam.contexts.template.kotlinsb.health

import org.egualpam.contexts.template.kotlinsb.shared.adapters.AbstractIntegrationTest
import org.junit.jupiter.api.Test

class ApplicationHealthCheck : AbstractIntegrationTest() {

  @Test
  fun `application status should be UP`() {
    webTestClient.get()
        .uri("/actuator/health")
        .exchange()
        .expectStatus()
        .isOk
        .expectBody()
        .json(
            """
              {
                "status": "UP"
              }
            """,
        )
  }
}
