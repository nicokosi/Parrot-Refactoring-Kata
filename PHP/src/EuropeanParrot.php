<?php
namespace Parrot;

class EuropeanParrot extends Parrot {
  
  public function getSpeed() {
    return $this->getBaseSpeed();
  }
  
}
