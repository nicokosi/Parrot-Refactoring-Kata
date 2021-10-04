import { Parrot, ParrotTypes } from "./parrot";

export class AfricanParrot extends Parrot {
  constructor(
    numberOfCoconuts: number,
    voltage: number,
    isNailed: boolean
  ) {
      super(ParrotTypes.AFRICAN, numberOfCoconuts, voltage, isNailed);
  }
}