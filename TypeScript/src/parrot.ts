export abstract class Parrot {
  public abstract getSpeed(): number;

  protected getBaseSpeed(): number {
    return 12;
  }

  protected getLoadFactor(): number {
    return 9;
  }
}
