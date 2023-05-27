package co.remotectrl.myapi.ctrl.cmd

import co.remotectrl.ctrl.event.CtrlCommand
import co.remotectrl.ctrl.event.CtrlEvent
import co.remotectrl.ctrl.event.CtrlMutable
import co.remotectrl.ctrl.event.CtrlValidation

class ItemAddCommand(val productId: String, val count: Int) : CtrlCommand<MyShoppingCart> {
    override fun makeEvent(): CtrlEvent<MyShoppingCart> {
        return ItemAddedEvent(productId, count)
    }

    override fun validate(aggregate: MyShoppingCart, validation: CtrlValidation) {
        validation.assert({ aggregate.items.containsKey(productId) }, "cannot add item because it already is in shopping cart")
    }
}

class ItemAddedEvent(val productId: String, val count: Int) :
    CtrlEvent<MyShoppingCart> {
    override fun applyChangesTo(mutable: MyShoppingCart): MyShoppingCart {
        return mutable.copy(
            items = mutable.items + (productId to count)
        )
    }

}

data class MyShoppingCart(val items: Map<String, Int>) : CtrlMutable<MyShoppingCart>
