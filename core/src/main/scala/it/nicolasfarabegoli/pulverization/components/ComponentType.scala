package it.nicolasfarabegoli.pulverization.components
/**
  * Components type in the pulverization model.
  */
enum ComponentType:
    case Behavior extends ComponentType
    case State extends ComponentType
    case Communication extends ComponentType
    case Sensors extends ComponentType
    case Actuators extends ComponentType
