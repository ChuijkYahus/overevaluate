package miyucomics.overevaluate.patterns.metaevals

import at.petrak.hexcasting.api.casting.SpellList
import at.petrak.hexcasting.api.casting.eval.vm.FrameForEach
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapNotEnoughArgs

object OpCastor : OpModifyThoth() {
	override fun updateFrame(frame: FrameForEach, stack: MutableList<Iota>) =
		frame.copy(data = SpellList.LPair(stack.removeLastOrNull() ?: throw MishapNotEnoughArgs(1, 0), frame.data))
}