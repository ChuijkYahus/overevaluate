package miyucomics.overevaluate.actions.handlers

import at.petrak.hexcasting.api.casting.castables.Action
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.eval.OperationResult
import at.petrak.hexcasting.api.casting.eval.vm.CastingImage
import at.petrak.hexcasting.api.casting.eval.vm.SpellContinuation
import at.petrak.hexcasting.api.casting.mishaps.MishapNotEnoughArgs
import at.petrak.hexcasting.common.lib.hex.HexEvalSounds

class OpGeb(private val amount: Int) : Action {
	override fun operate(env: CastingEnvironment, image: CastingImage, continuation: SpellContinuation): OperationResult {
		val stack = image.stack
		if (stack.size < amount + 1)
			throw MishapNotEnoughArgs(amount + 1, stack.size)
		val newStack = stack.toMutableList()
		val copy = newStack.removeAt(stack.size - amount - 1)
		newStack.add(copy)
		return OperationResult(image.withUsedOp().copy(stack = newStack), listOf(), continuation, HexEvalSounds.NORMAL_EXECUTE)
	}
}