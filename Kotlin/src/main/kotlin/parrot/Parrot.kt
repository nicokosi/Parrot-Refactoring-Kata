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
            ParrotTypeEnum.NORWEGIAN_BLUE -> NorwegianBlue(isNailed, voltage, baseSpeed).speed()
        }
}

class European : BaseParrot {

    override val speed: Double
        get() = baseSpeed
}

class African(private val numberOfCoconuts: Int) : BaseParrot {

    override val speed: Double
        get() = max(0.0, baseSpeed - loadFactor * numberOfCoconuts)

    private val loadFactor: Double
        get() = 9.0
}

class NorwegianBlue(
    private val isNailed: Boolean,
    private val voltage: Double,
    private val baseSpeed: Double
) {

    fun speed(
    ) = if (isNailed) 0.0 else getBaseSpeed(voltage, baseSpeed)

    private fun getBaseSpeed(voltage: Double, baseSpeed: Double): Double = min(24.0, voltage * baseSpeed)
}