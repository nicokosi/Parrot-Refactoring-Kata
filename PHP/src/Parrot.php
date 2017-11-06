<?php
namespace Parrot;

class Parrot {
  /** @var int ParrotTypeEnum */
  private $type;

  public function __construct($type, $numberOfCoconuts, $voltage, $isNailed) {
    $this->type = $type;
  }

  public function getSpeed() {
    throw new \Exception("Should be unreachable");
  }

  protected function getBaseSpeedWith($voltage) {
    return min(24.0, $voltage * $this->getBaseSpeed());
  }

  protected function getBaseSpeed() {
    return 12.0;
  }

}
