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
            ParrotTypeEnum.AFRICAN -> AfricanParrot(baseSpeed, loadFactor, numberOfCoconuts).speed
            ParrotTypeEnum.NORWEGIAN_BLUE -> norwegianBlueSpeed(isNailed, voltage)
        }

    private fun norwegianBlueSpeed(
        isNailed: Boolean,
        voltage: Double
    ) = if (isNailed) 0.0 else getBaseSpeed(voltage, baseSpeed)

    private val loadFactor: Double
        get() = 9.0

    private val baseSpeed: Double
        get() = 12.0

    private fun getBaseSpeed(voltage: Double, baseSpeed: Double): Double = min(24.0, voltage * baseSpeed)

}

class AfricanParrot(
    private val baseSpeed: Double,
    private val loadFactor: Double,
    private val numberOfCoconuts: Int
) {
    val speed: Double
        get() = max(0.0, this.baseSpeed - this.loadFactor * this.numberOfCoconuts)
}

class EuropeanParrot(val speed: Double)