package org.egualpam.contexts.template.kotlinsb.shared.adapters

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
      "org.egualpam.contexts.template.kotlinsb.shared.adapters.configuration",
      "org.egualpam.contexts.template.kotlinsb.helloworld.adapters.configuration",
      "org.egualpam.contexts.template.kotlinsb.helloworld.adapters.in.controllers",
    ],
)
class KotlinSbBackendTemplateApplication

fun main(args: Array<String>) {
  runApplication<KotlinSbBackendTemplateApplication>(*args)
}
