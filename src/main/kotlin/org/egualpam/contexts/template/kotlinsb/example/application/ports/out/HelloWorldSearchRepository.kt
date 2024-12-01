package org.egualpam.contexts.template.kotlinsb.example.application.ports.out

import org.egualpam.contexts.template.kotlinsb.example.application.domain.HelloWorldId
import org.egualpam.contexts.template.kotlinsb.example.application.usecases.query.HelloWorldDto

interface HelloWorldSearchRepository {
  fun search(id: HelloWorldId): HelloWorldDto
}
