package sbt

/** Processes progress events during task execution.
* All methods are called from the same thread except `started`,
* which is called from the executing task's thread.
* All methods should return quickly to avoid task execution overhead.*/
trait ExecuteProgress[S, A[_]]
{
	def initial: S
	def registered(state: S, task: A[_]): S
	def ready(state: S, task: A[_]): S

	/** Notifies that the task has started.
	* This is called from the thread the task executes on, unlike all other methods in this callback.*/
	def started(task: A[_]): Unit

	def completed[T](state: S, task: A[T], result: Result[T]): S
	def allCompleted(state: S, results: RMap[A,Result]): S
}

object ExecuteProgress
{
	def empty[A[_]]: ExecuteProgress[Unit, A] = new ExecuteProgress[Unit, A] {
		def initial = ()
		def registered(state: Unit, task: A[_]) = ()
		def ready(state: Unit, task: A[_]) = ()
		def started(task: A[_]) = ()
		def completed[T](state: Unit, task: A[T], result: Result[T]) = ()
		def allCompleted(state: Unit, results: RMap[A,Result]) = ()
	}
}