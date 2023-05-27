package co.remotectrl.myapi.ctrl.cmd

import co.remotectrl.ctrl.event.CtrlCommand
import co.remotectrl.ctrl.event.CtrlEvent
import co.remotectrl.ctrl.event.CtrlValidation
import co.remotectrl.myapi.ctrl.mutable.MyMutable
import co.remotectrl.myapi.ctrl.evt.MyChangedEvent

data class MyChangeCommand(val myChangeVal: String = "") : CtrlCommand<MyMutable> {
    override fun makeEvent(): CtrlEvent<MyMutable> {
        return MyChangedEvent(myChangeVal)
    }

    override fun validate(aggregate: MyMutable, validation: CtrlValidation) {
        validation.assert({myChangeVal.isNotEmpty()}, "myChangeVal should not be empty")
        validation.assert({aggregate.myVal !=  myChangeVal}, "myMutable.myVal is already this value")
    }
}