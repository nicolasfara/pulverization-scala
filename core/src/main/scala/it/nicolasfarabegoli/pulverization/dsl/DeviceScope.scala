package it.nicolasfarabegoli.pulverization.dsl

import it.nicolasfarabegoli.pulverization.components.ComponentType
import it.nicolasfarabegoli.pulverization.dsl.model.{Capability, LogicalDeviceSpecification}

import javax.xml.crypto.dsig.CanonicalizationMethod

class DeviceScope(private val deviceName: String):
  private var allocationMap: Map[ComponentType, Set[Capability]] = Map()

  def add(allocation: (ComponentType, Set[Capability])): Unit = allocationMap += allocation
  
  def generate: LogicalDeviceSpecification = LogicalDeviceSpecification(deviceName, allocationMap, allocationMap.keySet)