package co.remotectrl.myapi.ctrl.evt

import co.remotectrl.ctrl.event.CtrlEvent
import co.remotectrl.myapi.ctrl.mutable.MyMutable

data class MyChangedEvent(val myChangeVal: String) : CtrlEvent<MyMutable> {
    override fun applyChangesTo(mutable: MyMutable): MyMutable {
        return mutable.copy(
            myVal = myChangeVal
        )
    }
}