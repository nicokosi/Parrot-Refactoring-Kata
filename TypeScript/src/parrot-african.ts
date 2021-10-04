import { Parrot } from "./parrot";

export class AfricanParrot extends Parrot {
  constructor(protected numberOfCoconuts: number) {
    super();
  }
  private getLoadFactor(): number {
    return 9;
  }
  public getSpeed(): number {
    return Math.max(
      0,
      this.baseSpeed - this.getLoadFactor() * this.numberOfCoconuts
    );
  }
}
