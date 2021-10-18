package parrot

import kotlin.math.max
import kotlin.math.min

interface Parrot {
    fun speed(): Double
}

data class EuropeanParrot(val baseSpeed: Double) : Parrot {
    override fun speed(): Double = baseSpeed
}

data class AfricanParrot(val numberOfCoconuts: Int) : Parrot {
    private val baseSpeed = 12
    private val loadFactor = 9.0
    override fun speed(): Double = max(0.0, baseSpeed - loadFactor * numberOfCoconuts)
}

data class NorwegianBlueParrot(val voltage: Double, val isNailed: Boolean) : Parrot {
    override fun speed(): Double = if (isNailed) 0.0 else getBaseSpeed(voltage)
    private fun getBaseSpeed(voltage: Double): Double = min(24.0, voltage * 12)
}
