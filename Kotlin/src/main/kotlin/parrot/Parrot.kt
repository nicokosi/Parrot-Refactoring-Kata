package parrot

import kotlin.math.max
import kotlin.math.min

interface IParrot {
    val speed: Double
}

data class EuropeanParrot(val baseSpeed: Double) : IParrot {
    override val speed: Double
        get() = baseSpeed
}

data class AfricanParrot(val numberOfCoconuts: Int) : IParrot {
    private val baseSpeed = 12
    private val loadFactor = 9.0
    override val speed: Double
        get() = max(0.0, baseSpeed - loadFactor * numberOfCoconuts)
}

data class NorwegianBlueParrot(val voltage: Double, val isNailed: Boolean) : IParrot {
    override val speed: Double
        get() = if (isNailed) 0.0 else getBaseSpeed(voltage)
    private fun getBaseSpeed(voltage: Double): Double = min(24.0, voltage * 12)
}
