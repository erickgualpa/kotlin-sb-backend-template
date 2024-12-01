package org.egualpam.contexts.template.kotlinsb.example.adapters.`in`.controllers

import org.egualpam.contexts.template.kotlinsb.example.application.usecases.command.CreateHelloWorld
import org.egualpam.contexts.template.kotlinsb.example.application.usecases.command.CreateHelloWorldCommand
import org.egualpam.contexts.template.kotlinsb.shared.application.domain.exceptions.InvalidAggregateId
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.internalServerError
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.notFound
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/hello-world")
@RestController
class PutHelloWorldController(
  val createHelloWorld: CreateHelloWorld
) {

  private val logger: Logger = getLogger(this::class.java)

  @PutMapping("/{id}")
  fun putHelloWorld(@PathVariable id: String): ResponseEntity<Unit> {
    return try {
      val command = CreateHelloWorldCommand(id)
      createHelloWorld.execute(command)
      noContent().build()
    } catch (e: RuntimeException) {
      return when (e.javaClass) {
        InvalidAggregateId::class.java -> {
          logger.warn(e.message)
          notFound().build()
        }

        else -> {
          logger.error("Unexpected error processing request:", e)
          internalServerError().build()
        }
      }
    }
  }
}
