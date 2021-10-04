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
            ParrotTypeEnum.EUROPEAN -> EuropeanParrot(baseSpeed).speed
            ParrotTypeEnum.AFRICAN -> africanSpeed(baseSpeed, loadFactor, numberOfCoconuts)
            ParrotTypeEnum.NORWEGIAN_BLUE -> norwegianBlueSpeed()
        }

    private fun norwegianBlueSpeed() = if (isNailed) 0.0 else getBaseSpeed(voltage)

    private fun africanSpeed(
        baseSpeed: Double,
        loadFactor: Double,
        numberOfCoconuts: Int
    ) = max(0.0, baseSpeed - loadFactor * numberOfCoconuts)

    private val loadFactor: Double
        get() = 9.0

    private val baseSpeed: Double
        get() = 12.0

    private fun getBaseSpeed(voltage: Double): Double = min(24.0, voltage * baseSpeed)

}

class EuropeanParrot(val speed: Double)