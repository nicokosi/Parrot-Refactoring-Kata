export abstract class Parrot {
  public abstract get speed(): number;

  protected get baseSpeed() {
    return 12;
  }
}
