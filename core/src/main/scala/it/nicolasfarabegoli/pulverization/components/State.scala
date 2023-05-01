package it.nicolasfarabegoli.pulverization.components

import it.nicolasfarabegoli.pulverization.context.Context
import zio.{IO, ZIO}

/**
 * The _State_ component of the pulverization model.
 *
 * @tparam S the type of the state.
 */
trait State[S] extends PulverizedComponent:
    override val component: ComponentType = ComponentType.State

    /**
      * Returns the current state.
      *
      * @return the current state.
      */
    def get: IO[Unit, S]

    /**
      * Updates the current state.
      *
      * @param s the nre state.
      */
    def update(s: S): IO[Unit, Unit]
