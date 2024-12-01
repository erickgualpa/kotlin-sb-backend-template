package org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out

import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorldId
import org.egualpam.contexts.template.kotlinsb.helloworld.application.usecases.query.HelloWorldDto

interface HelloWorldSearchRepository {
  fun search(id: HelloWorldId): HelloWorldDto
}
