package parrot

import kotlin.math.max
import kotlin.math.min

open class Parrot(
    private val type: ParrotTypeEnum,
    private val numberOfCoconuts: Int,
    private val voltage: Double,
    private val isNailed: Boolean
) {

    val speed: Double
        get() = when (type) {
            ParrotTypeEnum.EUROPEAN -> europeanSpeed(baseSpeed)
            ParrotTypeEnum.AFRICAN -> africanSpeed()
            ParrotTypeEnum.NORWEGIAN_BLUE -> norwegianBlueSpeed()
        }

    private fun norwegianBlueSpeed() = if (isNailed) 0.0 else getBaseSpeed(voltage)

    private fun africanSpeed() = max(0.0, baseSpeed - loadFactor * numberOfCoconuts)

    private val loadFactor: Double
        get() = 9.0

    private val baseSpeed: Double
        get() = 12.0

    private fun getBaseSpeed(voltage: Double): Double = min(24.0, voltage * baseSpeed)

    private fun europeanSpeed(baseSpeed: Double) = baseSpeed
}

class EuropeanParrot {
    private fun europeanSpeed(baseSpeed: Double) = baseSpeed
}