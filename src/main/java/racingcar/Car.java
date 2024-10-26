package racingcar;

class Car {
  private String name;
  private int position;

  public Car(String name) {
    this.name = name;
    validateName(name);
  }

  private void validateName(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("이름은 5자 이상이여만 가능합니다.");
    }
  }

  public void move() {
    if (Dice.rolling() >= 4) {
      position++;
    }
  }
  
  public void showPosition() {
    System.out.println(name + " : " + "-".repeat(position));
  }
  
  public String getName() {
    return name;
  }
  
  public int getPosition() {
    return position;
  }
  
}