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
            ParrotTypeEnum.EUROPEAN -> EuropeanParrot(baseSpeed)
            ParrotTypeEnum.AFRICAN -> AfricanParrot(baseSpeed, loadFactor, numberOfCoconuts)
            ParrotTypeEnum.NORWEGIAN_BLUE -> NorwegianBlueParrot(isNailed, voltage, baseSpeed)
        }.speed

    private val loadFactor: Double
        get() = 9.0

    private val baseSpeed: Double
        get() = 12.0


}

abstract class BaseParrot(baseSpeed: Double) {
    abstract val speed: Double
}

class NorwegianBlueParrot(
    private val isNailed: Boolean,
    private val voltage: Double,
    private val baseSpeed: Double
) : BaseParrot(baseSpeed) {
    override val speed: Double
        get() = if (this.isNailed) 0.0 else min(24.0, this.voltage * this.baseSpeed)
}

class AfricanParrot(
    private val baseSpeed: Double,
    private val loadFactor: Double,
    private val numberOfCoconuts: Int
) : BaseParrot(baseSpeed) {
    override val speed: Double
        get() = max(0.0, this.baseSpeed - this.loadFactor * this.numberOfCoconuts)
}

class EuropeanParrot(private val baseSpeed: Double) : BaseParrot(baseSpeed) {
    override val speed: Double
        get() = this.baseSpeed
}