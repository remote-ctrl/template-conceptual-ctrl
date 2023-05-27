package co.remotectrl.myapi.ctrl.cmd

import co.remotectrl.ctrl.event.CtrlCommand
import co.remotectrl.ctrl.event.CtrlEvent
import co.remotectrl.ctrl.event.CtrlValidation
import co.remotectrl.myapi.ctrl.mutable.MyMutable
import co.remotectrl.myapi.ctrl.evt.MyCreatedEvent

data class MyCreateCommand(val myInitialVal: String = "") : CtrlCommand<MyMutable> {
    override fun makeEvent(): CtrlEvent<MyMutable> {
        return MyCreatedEvent(myInitialVal)
    }

    override fun validate(aggregate: MyMutable, validation: CtrlValidation) {
        validation.assert({myInitialVal.isNotEmpty()}, "myInitialVal should not be empty")
    }
}