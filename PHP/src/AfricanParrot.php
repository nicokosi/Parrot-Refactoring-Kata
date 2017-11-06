<?php
namespace Parrot;

class AfricanParrot extends Parrot {

  /** @var int */
  private $numberOfCoconuts;

  function __construct($numberOfCoconuts) {
    $this->numberOfCoconuts = $numberOfCoconuts;
  }

  function getSpeed() {
    return max(0, $this->getBaseSpeed() - $this->getLoadFactor() * $this->numberOfCoconuts);
  }

  private function getLoadFactor() {
    return 9.0;
  }

}
