package co.remotectrl.myevent.command

import co.remotectrl.ctrl.event.*
import co.remotectrl.myapi.ctrl.mutable.MyMutable
import co.remotectrl.myapi.ctrl.cmd.MyChangeCommand
import co.remotectrl.myapi.ctrl.evt.MyChangedEvent
import co.remotectrl.myevent.assert.AssertUtil
import kotlin.test.Test

class MyAggregateTest {

    private val myAggregate = MyMutable("blah")

    private fun getPlayer(
        aggregate: MyMutable
    ): CtrlMutablePlayer<MyMutable> = CtrlMutablePlayer(mutable = aggregate)

    @Test
    fun should_try_to_validate_Change_command_input() {

        AssertUtil.assertExecution(
            getPlayer(aggregate = myAggregate).execute(MyChangeCommand("")),
            CtrlExecution.Invalidated(
                items = arrayOf(
                    CtrlInvalidInput("myChangeVal should not be empty")
                )
            )
        )
        AssertUtil.assertExecution(
            getPlayer(aggregate = myAggregate).execute(MyChangeCommand("blah")),
            CtrlExecution.Invalidated(
                items = arrayOf(
                    CtrlInvalidInput("myMutable.myVal is already this value")
                )
            )
        )


    }

    @Test
    fun should_produce_Changed_event_on_successful_Commit_command() {
        AssertUtil.assertExecution(
            getPlayer(aggregate = myAggregate).execute(MyChangeCommand("change blah")),
            CtrlExecution.Validated(
                event = MyChangedEvent("change blah")
            )
        )
    }

    @Test
    fun should_apply_Changed_event_to_the_MyAggregate() {
        val evt = MyChangedEvent("blah changed")

        val actual = evt.applyChangesTo(myAggregate)

        val expected = MyMutable("blah changed")

        kotlin.test.assertEquals(actual.myVal, expected.myVal)
    }

}
