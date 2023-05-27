package co.remotectrl.myapi.ctrl.mutable

import co.remotectrl.ctrl.event.CtrlMutable

data class MyMutable(
    val myVal: String
) : CtrlMutable<MyMutable>
