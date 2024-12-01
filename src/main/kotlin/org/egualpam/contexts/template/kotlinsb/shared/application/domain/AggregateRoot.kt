package org.egualpam.contexts.template.kotlinsb.shared.application.domain

abstract class AggregateRoot(private val aggregateId: AggregateId) {

  private val domainEvents = mutableSetOf<DomainEvent>()

  fun addDomainEvent(domainEvent: DomainEvent) {
    domainEvents.add(domainEvent)
  }

  fun pullDomainEvents(): Set<DomainEvent> {
    val domainEventsCopy = HashSet(domainEvents)
    domainEvents.clear()
    return domainEventsCopy
  }

  fun id(): AggregateId = this.aggregateId

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as AggregateRoot

    return id() == other.id()
  }

  override fun hashCode(): Int {
    return id().hashCode()
  }
}
