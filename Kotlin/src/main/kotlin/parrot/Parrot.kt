package parrot

import kotlin.math.max
import kotlin.math.min

interface Parrot {
    val speed: Double
}

data class EuropeanParrot(val baseSpeed: Double) : Parrot {
    override val speed: Double
        get() = baseSpeed
}

data class AfricanParrot(val numberOfCoconuts: Int) : Parrot {
    private val baseSpeed = 12
    private val loadFactor = 9.0
    override val speed: Double
        get() = max(0.0, baseSpeed - loadFactor * numberOfCoconuts)
}

data class NorwegianBlueParrot(val voltage: Double, val isNailed: Boolean) : Parrot {
    override val speed: Double
        get() = if (isNailed) 0.0 else getBaseSpeed(voltage)
    private fun getBaseSpeed(voltage: Double): Double = min(24.0, voltage * 12)
}
