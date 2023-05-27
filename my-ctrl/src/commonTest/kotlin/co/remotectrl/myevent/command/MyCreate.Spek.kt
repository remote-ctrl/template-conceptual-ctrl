package co.remotectrl.myevent.command

import co.remotectrl.ctrl.event.*
import co.remotectrl.myapi.ctrl.mutable.MyMutable
import co.remotectrl.myapi.ctrl.cmd.MyCreateCommand
import co.remotectrl.myapi.ctrl.evt.MyCreatedEvent
import co.remotectrl.myevent.assert.AssertUtil
import kotlin.test.Test

class MyCreateTest {

    private val myAggregate = MyMutable(
        myVal = "",
    )

    private fun getPlayer(aggregate: MyMutable): CtrlMutablePlayer<MyMutable> = CtrlMutablePlayer(
        mutable = aggregate
    )

    @Test
    fun should_try_to_validate_Change_Command_command_input() {
        AssertUtil.assertExecution(
            getPlayer(myAggregate).execute(MyCreateCommand()),
            CtrlExecution.Invalidated(
                items = arrayOf(
                    CtrlInvalidInput("myInitialVal should not be empty")
                )
            )
        )
    }

    private val evtIdVal = "0"
    private val evtId = CtrlEventId<MyMutable>(evtIdVal)

    @Test
    fun should_produce_Changed_Event_on_successful_Commit_Command() {

        AssertUtil.assertExecution(
            getPlayer(myAggregate).execute(MyCreateCommand("initial blah")),
            CtrlExecution.Validated(
                event = MyCreatedEvent("blah changed")
            )
        )
    }

    @Test
    fun should_apply_Changed_Event_to_MyAggregate() {
        val evt = MyCreatedEvent("blah")

        val actual = evt.applyChangesTo(myAggregate)
        val expected = MyMutable(myVal = "blah")

        kotlin.test.assertEquals(actual.myVal, expected.myVal)
    }

}
