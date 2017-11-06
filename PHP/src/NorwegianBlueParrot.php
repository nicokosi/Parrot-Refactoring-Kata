<?php
namespace Parrot;

class NorwegianBlueParrot extends Parrot {

  public function getSpeed() {
    return $this->isNailed ? 0 : $this->getBaseSpeedWith($this->voltage);
  }

}
