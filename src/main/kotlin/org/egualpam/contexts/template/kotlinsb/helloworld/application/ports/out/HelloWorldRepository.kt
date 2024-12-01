package org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out

import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorld
import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorldId

interface HelloWorldRepository {
  fun find(id: HelloWorldId): HelloWorld?
  fun save(helloWorld: HelloWorld)
}
