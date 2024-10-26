package racingcar;

class Car {
  private String name;
  private int position;
  public Car(String name) {
      if (name.length() > 5) {
          throw new IllegalArgumentException("이름은 5자 이상이여만 가능합니다.");
      }
      this.name = name;
  }
  public void move() {
      Dice dice = new Dice();
      dice.rolling();
      if (dice.getNumber() >= 4) {
          position++;
      }
      System.out.println("");
      
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