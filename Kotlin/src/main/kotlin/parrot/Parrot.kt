package parrot

import kotlin.math.max
import kotlin.math.min

interface IParrot {
    fun speed(): Double
}

data class EuropeanParrot(val baseSpeed: Double) : IParrot {
    override fun speed(): Double = baseSpeed
}

data class AfricanParrot(val numberOfCoconuts: Int) : IParrot {
    private val baseSpeed = 12
    private val loadFactor = 9.0

    override fun speed(): Double = max(0.0, baseSpeed - loadFactor * numberOfCoconuts)
}

open class Parrot(
    private val type: ParrotTypeEnum,
    private val numberOfCoconuts: Int,
    private val voltage: Double,
    private val isNailed: Boolean
) {

    val speed: Double
        get() = when (type) {
            ParrotTypeEnum.EUROPEAN -> baseSpeed
            ParrotTypeEnum.AFRICAN -> max(0.0, baseSpeed - loadFactor * numberOfCoconuts)
            ParrotTypeEnum.NORWEGIAN_BLUE -> if (isNailed) 0.0 else getBaseSpeed(voltage)
        }

    private val loadFactor: Double
        get() = 9.0

    private val baseSpeed: Double
        get() = 12.0

    private fun getBaseSpeed(voltage: Double): Double = min(24.0, voltage * baseSpeed)
}
