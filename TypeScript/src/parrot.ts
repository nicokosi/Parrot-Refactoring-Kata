export abstract class Parrot {
  public abstract getSpeed(): number;

  protected get baseSpeed() {
    return 12;
  }
}
