package org.egualpam.contexts.template.kotlinsb.architecture

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class HexagonalArchitectureTest {

  private val importedClasses =
      ClassFileImporter().importPackages("org.egualpam.contexts.template.kotlinsb")

  @Test
  fun `domain should not depend on application use cases`() {
    noClasses().that().resideInAPackage("..domain..")
        .should().dependOnClassesThat()
        .resideInAnyPackage("..usecases..")
        .check(importedClasses)
  }

  @Test
  fun `domain should not depend on adapters`() {
    noClasses().that().resideInAPackage("..domain..")
        .should().dependOnClassesThat()
        .resideInAnyPackage("..adapters..")
        .check(importedClasses)
  }

  @Test
  fun `application should not depend on adapters`() {
    noClasses().that().resideInAPackage("..application..")
        .should().dependOnClassesThat()
        .resideInAnyPackage("..adapters..")
        .check(importedClasses)
  }
}
