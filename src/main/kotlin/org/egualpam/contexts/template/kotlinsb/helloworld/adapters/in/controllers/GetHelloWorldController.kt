package org.egualpam.contexts.template.kotlinsb.helloworld.adapters.`in`.controllers

import org.egualpam.contexts.template.kotlinsb.helloworld.application.usecases.query.RetrieveHelloWorld
import org.egualpam.contexts.template.kotlinsb.helloworld.application.usecases.query.RetrieveHelloWorldQuery
import org.egualpam.contexts.template.kotlinsb.shared.application.domain.exceptions.InvalidAggregateId
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.internalServerError
import org.springframework.http.ResponseEntity.notFound
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/hello-world")
@RestController
class GetHelloWorldController(
  val retrieveHelloWorld: RetrieveHelloWorld
) {

  private val logger: Logger = getLogger(this::class.java)

  @GetMapping("/{id}")
  fun getHelloWorld(@PathVariable id: String): ResponseEntity<GetHelloWorldResponse> {
    return try {
      val query = RetrieveHelloWorldQuery(id)
      val helloWorld = retrieveHelloWorld.execute(query)
      val response = GetHelloWorldResponse(helloWorld.id)
      ok(response)
    } catch (e: RuntimeException) {
      return when (e.javaClass) {
        InvalidAggregateId::class.java -> {
          logger.warn(e.message)
          notFound().build()
        }

        else -> {
          logger.error("Unexpected error processing request: ", e)
          internalServerError().build()
        }
      }
    }
  }

  data class GetHelloWorldResponse(
    val id: String
  )
}
