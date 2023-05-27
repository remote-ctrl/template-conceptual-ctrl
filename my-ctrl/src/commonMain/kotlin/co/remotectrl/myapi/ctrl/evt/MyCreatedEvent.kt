package co.remotectrl.myapi.ctrl.evt

import co.remotectrl.ctrl.event.CtrlEvent
import co.remotectrl.myapi.ctrl.mutable.MyMutable

data class MyCreatedEvent(val myInitialVal: String) : CtrlEvent<MyMutable> {
    constructor() : this("")
    override fun applyChangesTo(mutable: MyMutable): MyMutable {
        return mutable.copy(
            myVal = myInitialVal
        )
    }
}
