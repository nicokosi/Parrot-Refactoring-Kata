<?php
namespace Parrot;

class NorwegianBlueParrot extends Parrot {

  /** @var double */
  private $voltage;
  /** @var boolean */
  private $isNailed;

  public function __construct($voltage, $isNailed) {
    $this->voltage = $voltage;
    $this->isNailed = $isNailed;
  }

  public function getSpeed() {
    return $this->isNailed ? 0 : $this->getBaseSpeedWith($this->voltage);
  }

}
