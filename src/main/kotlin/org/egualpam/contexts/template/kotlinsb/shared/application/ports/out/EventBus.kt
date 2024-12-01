package org.egualpam.contexts.template.kotlinsb.shared.application.ports.out

import org.egualpam.contexts.template.kotlinsb.shared.application.domain.DomainEvent

interface EventBus {
  fun publish(domainEvents: Set<DomainEvent>)
}
