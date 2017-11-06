<?php
namespace Parrot;

class Parrot {
  /** @var int ParrotTypeEnum */
  private $type;
  /** @var double */
  private $voltage;
  /** @var boolean */
  private $isNailed;

  public function __construct($type, $numberOfCoconuts, $voltage, $isNailed) {
    $this->type = $type;
    $this->voltage = $voltage;
    $this->isNailed = $isNailed;
  }

  public function getSpeed() {
    switch ($this->type) {
      case ParrotTypeEnum::NORWEGIAN_BLUE:
        return $this->isNailed ? 0 : $this->getBaseSpeedWith($this->voltage);
    }
    throw new \Exception("Should be unreachable");
  }

  protected function getBaseSpeedWith($voltage) {
    return min(24.0, $voltage * $this->getBaseSpeed());
  }

  protected function getBaseSpeed() {
    return 12.0;
  }

}
