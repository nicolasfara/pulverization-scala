package it.nicolasfarabegoli.pulverization.components

import it.nicolasfarabegoli.pulverization.context.Context
import zio.{IO, ZIO}

/**
 * A sensor that can take part of the _Sensors_ component in the pulverization model.
 * @tparam S the type of the sensed value.
 */
trait Sensor[+S]:
  /**
   * Sense the environment.
   * @return the sensed value.
   */
  def sense: IO[Unit, S]

/**
 * The _Sensors_ component in the pulverization model.
 */
trait Sensors extends PulverizedComponent:
  override val component: ComponentType = ComponentType.Sensors

  private var sensors: Set[Sensor[_]] = Set()

  def +=[S](sensor: Sensor[S]): Unit = sensors += sensor

  def ++=[S](sensors: Seq[Sensor[S]]): Unit = this.sensors ++= sensors

  def get[S <: Sensor[_]]: Option[S] = ???

  def get[S : Sensor](exec: S => Unit): Unit = ???
