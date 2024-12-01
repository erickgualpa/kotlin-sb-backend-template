package org.egualpam.contexts.template.kotlinsb.example.application.usecases.query

import org.egualpam.contexts.template.kotlinsb.example.application.domain.HelloWorldId
import org.egualpam.contexts.template.kotlinsb.example.application.ports.out.HelloWorldSearchRepository

class RetrieveHelloWorld(
  private val repository: HelloWorldSearchRepository
) {
  fun execute(query: RetrieveHelloWorldQuery): HelloWorldDto {
    val helloWorldId = HelloWorldId(query.id)
    return repository.search(helloWorldId)
  }
}

data class RetrieveHelloWorldQuery(val id: String)

data class HelloWorldDto(
  val id: String
)
