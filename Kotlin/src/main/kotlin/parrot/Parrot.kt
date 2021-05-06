package parrot

import kotlin.math.max
import kotlin.math.min

interface BaseParrot {
    val speed: Double

    val baseSpeed: Double
        get() = 12.0
}

open class Parrot(
    private val type: ParrotTypeEnum,
    private val numberOfCoconuts: Int,
    private val voltage: Double,
    private val isNailed: Boolean
) : BaseParrot {

    override val speed: Double
        get() = when (type) {
            ParrotTypeEnum.AFRICAN -> African(numberOfCoconuts).speed
            ParrotTypeEnum.NORWEGIAN_BLUE -> if (isNailed) 0.0 else getBaseSpeed(voltage)
        }

    private fun getBaseSpeed(voltage: Double): Double = min(24.0, voltage * baseSpeed)
}

class EuropeanParrot : BaseParrot {

    override val speed: Double
        get() = baseSpeed
}

class African(private val numberOfCoconuts: Int) : BaseParrot {

    override val speed: Double
        get() = max(0.0, baseSpeed - loadFactor * numberOfCoconuts)

    private val loadFactor: Double
        get() = 9.0
}