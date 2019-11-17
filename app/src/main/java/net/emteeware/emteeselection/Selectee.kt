package net.emteeware.emteeselection

class Selectee(var name: String) {
    var selected : Boolean = false

    override fun toString(): String {
        return if (selected) "$name *" else name
    }
}