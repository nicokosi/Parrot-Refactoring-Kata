<?php
namespace Parrot;

class Parrot {
  /** @var int ParrotTypeEnum */
  private $type;
  /** @var int */
  protected $numberOfCoconuts = 0;
  /** @var double */
  private $voltage;
  /** @var boolean */
  private $isNailed;

  public function __construct($type, $numberOfCoconuts, $voltage, $isNailed) {
    $this->type = $type;
    $this->numberOfCoconuts = $numberOfCoconuts;
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

  protected function getLoadFactor() {
    return 9.0;
  }

  protected function getBaseSpeed() {
    return 12.0;
  }

}
