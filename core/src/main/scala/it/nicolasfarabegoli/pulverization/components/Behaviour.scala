package it.nicolasfarabegoli.pulverization.components

/**
  * Represents the output of the execution of the [Behaviour].
  *
  * @param communication the communication information to be sent to the other devices.
  * @param actuators the action to be performed by the actuators.
  * @param output the outcome of the behaviour.
  */
final case class BehaviourOutput[C, AS, O](communication: C, actuators: AS, output: O)

/**
  * The _Behaviour_ component of the pulverization model.
  */
trait Behavior[S, C, SS, AS, O] extends ((S, List[C], SS) => BehaviourOutput[C, AS, O]), PulverizedComponent:
    override val component: ComponentType = ComponentType.Behavior
