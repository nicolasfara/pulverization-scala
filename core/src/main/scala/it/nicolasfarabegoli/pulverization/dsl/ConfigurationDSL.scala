package it.nicolasfarabegoli.pulverization.dsl

import it.nicolasfarabegoli.pulverization.components.ComponentType
import it.nicolasfarabegoli.pulverization.components.ComponentType.{Behavior, Communication, Sensors}
import it.nicolasfarabegoli.pulverization.dsl.PulverizationSystemScope
import it.nicolasfarabegoli.pulverization.dsl.model.{Capability, SystemSpecification}

case object Smartphone extends Capability
case object Server extends Capability

def pulverizationSystem(init: PulverizationSystemScope ?=> Unit): SystemSpecification =
  given scope: PulverizationSystemScope = PulverizationSystemScope()
  init
  scope.generate

def device(name: String)(init: DeviceScope ?=> Unit)(using scope: PulverizationSystemScope): Unit =
  given device: DeviceScope = DeviceScope(name)
  init
  scope.add(device.generate)

extension(component: ComponentType)
  def deployableOn(capability: Capability)(using device: DeviceScope): Unit =
    device.add((component, Set(capability)))

  def deployableOn(capabilities: Set[Capability])(using device: DeviceScope): Unit =
    device.add((component, capabilities))

extension(components: Set[ComponentType])
  def deployableOn(capability: Capability)(using device: DeviceScope): Unit =
    components.foreach { e => device.add((e, Set(capability))) }

extension(components: ComponentType)
  def and(otherComponent: ComponentType): Set[ComponentType] = Set(components, otherComponent)

val a = pulverizationSystem {
  device("ciao") {
    Behavior and Communication deployableOn Smartphone
    Sensors deployableOn Set(Smartphone, Server)
  }
}