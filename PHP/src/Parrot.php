<?php
namespace Parrot;

abstract class Parrot {

  abstract function getSpeed();

  protected function getBaseSpeed() {
    return 12.0;
  }

}
