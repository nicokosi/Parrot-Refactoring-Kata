<?php
namespace Parrot;

class AfricanParrot extends Parrot {
  
  public function getSpeed() {
    return max(0, $this->getBaseSpeed() - $this->getLoadFactor() * $this->numberOfCoconuts);
  }
  
}
