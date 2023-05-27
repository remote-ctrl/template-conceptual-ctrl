package co.remotectrl.myevent.assert

import co.remotectrl.ctrl.event.*

class AssertUtil {
    companion object {

        fun <TMutable : CtrlMutable<TMutable>> assertExecution(
            actual: CtrlExecution<TMutable, CtrlEvent<TMutable>, CtrlInvalidation>,
            expected: CtrlExecution.Validated<TMutable, CtrlEvent<TMutable>>
        ) {
            assertEventType((actual as CtrlExecution.Validated).event, expected.event)
        }

        private fun <TMutable : CtrlMutable<TMutable>> assertEventType(
            actual: CtrlEvent<TMutable>,
            expected: CtrlEvent<TMutable>
        ) {
            kotlin.test.assertEquals(actual::class, expected::class)
        }

        fun <TMutable : CtrlMutable<TMutable>> assertExecution(
            actualExecution: CtrlExecution<TMutable, CtrlEvent<TMutable>, CtrlInvalidation>,
            expectedExecution: CtrlExecution.Invalidated<TMutable>
        ) {
            val actualInvalid = (actualExecution as CtrlExecution.Invalidated)
            kotlin.test.assertEquals(expectedExecution.items.size, actualInvalid.items.size)
            kotlin.test.assertEquals(expectedExecution.items[0].description, actualInvalid.items[0].description)
        }
    }
}
