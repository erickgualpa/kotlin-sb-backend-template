package org.egualpam.contexts.template.kotlinsb.shared.adapters

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

/*import org.testcontainers.containers.ComposeContainer
import java.io.File*/

@ActiveProfiles("integration-test")
@SpringBootTest(
    webEnvironment = RANDOM_PORT,
    classes = [KotlinSbBackendTemplateApplication::class],
)
abstract class AbstractIntegrationTest {

  @Autowired
  protected lateinit var webTestClient: WebTestClient

  companion object {
    /*private val containers = ComposeContainer(File("docker-compose.yml"))

    init {
      containers.start()
    }*/
  }
}
