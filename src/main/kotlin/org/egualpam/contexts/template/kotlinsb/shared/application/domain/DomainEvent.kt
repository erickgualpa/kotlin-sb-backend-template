package org.egualpam.contexts.template.kotlinsb.shared.application.domain;

import java.time.Instant

abstract class DomainEvent(
  private val domainEventId: DomainEventId,
  private val occurredOn: Instant,
  private val aggregateRoot: AggregateRoot,
) {
  fun id() = domainEventId

  fun occurredOn() = occurredOn

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as DomainEvent

    return id() == other.id()
  }

  override fun hashCode(): Int {
    return id().hashCode()
  }
}
