package org.egualpam.contexts.template.kotlinsb.shared.application.domain

import org.egualpam.contexts.template.kotlinsb.shared.application.domain.exceptions.InvalidAggregateId
import java.util.UUID

open class AggregateId(value: String) {
  init {
    try {
      UUID.fromString(value)
    } catch (e: IllegalArgumentException) {
      throw InvalidAggregateId(value)
    }
  }
}
