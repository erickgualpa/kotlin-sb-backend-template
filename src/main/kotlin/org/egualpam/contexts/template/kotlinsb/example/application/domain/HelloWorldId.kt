package org.egualpam.contexts.template.kotlinsb.example.application.domain

import org.egualpam.contexts.template.kotlinsb.shared.application.domain.AggregateId

data class HelloWorldId(val value: String) : AggregateId(value)
