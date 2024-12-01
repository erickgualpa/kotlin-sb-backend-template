package org.egualpam.contexts.template.kotlinsb.architecture

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.egualpam.contexts.template.kotlinsb.shared.application.domain.AggregateRoot
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class HelloWorldArchitectureTest {

  private val importedClasses =
      ClassFileImporter().importPackages("org.egualpam.contexts.template.kotlinsb")

  // TODO: Enable once hello world entity is created
  @Disabled
  @Test
  fun `hello world entity should be the aggregate root`() {
    classes().that()
        .resideInAPackage("..domain..")
        .and()
        .haveNameMatching(".*HelloWorld")
        .should()
        .beAssignableTo(AggregateRoot::class.java)
        .check(importedClasses)
  }
}
