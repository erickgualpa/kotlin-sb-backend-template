package org.egualpam.contexts.template.kotlinsb.helloworld.application.ports.out

import org.egualpam.contexts.template.kotlinsb.helloworld.application.domain.HelloWorldId

interface HelloWorldExists {
  fun with(id: HelloWorldId): Boolean
}
