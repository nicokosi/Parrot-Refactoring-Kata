<?php
namespace Parrot;

class AfricanParrot extends Parrot {
  
  /** @var int */
  private $numberOfCoconuts = 0;
  
  public function __construct($type, $numberOfCoconuts, $voltage, $isNailed) {
    $this->numberOfCoconuts = $numberOfCoconuts;
  }
  
  public function getSpeed() {
    return max(0, $this->getBaseSpeed() - $this->getLoadFactor() * $this->numberOfCoconuts);
  }

  private function getLoadFactor() {
    return 9.0;
  }
  
  
}
