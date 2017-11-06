<?php
namespace Parrot;

class NorwegianBlueParrot extends Parrot {

  /** @var double */
  private $voltage;
  /** @var boolean */
  private $isNailed;

  function __construct($voltage, $isNailed) {
    $this->voltage = $voltage;
    $this->isNailed = $isNailed;
  }

  function getSpeed() {
    return $this->isNailed ? 0 : $this->computeBaseSpeedForVoltage();
  }

  private function computeBaseSpeedForVoltage() {
    return min(24.0, $this->voltage * $this->getBaseSpeed());
  }

}
