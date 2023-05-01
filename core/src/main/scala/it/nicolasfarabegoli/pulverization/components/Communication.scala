package it.nicolasfarabegoli.pulverization.components

import it.nicolasfarabegoli.pulverization.context.Context
import zio.{IO, ZIO}
import zio.stream.Stream

/**
 * The _Communication_ component of the pulverization model.
 * @tparam C the communication type.
 */
trait Communication[C] extends PulverizedComponent:
    override val component: ComponentType = ComponentType.Communication

    /**
     * Send message to neighbours.
     * @param message to be send.
     */
    def send(message: C): IO[Unit, Unit]

    /**
     * Receive messages from neighbours.
     * @return
     */
    def receive: IO[Unit, C]
