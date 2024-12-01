package org.egualpam.contexts.template.kotlinsb.shared.application.domain

import org.egualpam.contexts.template.kotlinsb.shared.application.domain.exceptions.InvalidDomainEntityId
import java.util.UUID

open class DomainEntityId(value: String) {
  init {
    try {
      UUID.fromString(value)
    } catch (e: IllegalArgumentException) {
      throw InvalidDomainEntityId(value)
    }
  }
}
