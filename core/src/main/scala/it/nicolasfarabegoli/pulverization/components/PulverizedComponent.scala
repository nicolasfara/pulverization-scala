package it.nicolasfarabegoli.pulverization.components

import it.nicolasfarabegoli.pulverization.components.ComponentType
import it.nicolasfarabegoli.pulverization.context.Context

/**
  * Interface representing a pulverized component.
  */
trait PulverizedComponent(using Context):
    /**
      * The component type.
      */
    val component: ComponentType
