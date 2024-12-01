package org.egualpam.contexts.template.kotlinsb.shared.application.domain.exceptions

class InvalidAggregateId(value: String) :
  RuntimeException("The provided id [$value] is invalid")
