package it.nicolasfarabegoli.pulverization.dsl.model

import it.nicolasfarabegoli.pulverization.components.ComponentType

trait Capability

final case class LogicalDeviceSpecification(deviceName: String, requiredCapabilities: Map[ComponentType, Set[Capability]], components: Set[ComponentType])

final case class SystemSpecification(devicesConfiguration: Set[LogicalDeviceSpecification])