package it.nicolasfarabegoli.pulverization.dsl

import it.nicolasfarabegoli.pulverization.dsl.model.{LogicalDeviceSpecification, SystemSpecification}

class PulverizationSystemScope {
  private var specifications: Set[LogicalDeviceSpecification] = Set()

  def add(deviceSpecification: LogicalDeviceSpecification): Unit = specifications += deviceSpecification

  def generate: SystemSpecification = SystemSpecification(specifications)
}
