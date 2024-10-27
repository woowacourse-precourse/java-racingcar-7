package racingcar;

public class Car {

   private String name;
   private int position;

   public void giveCarName(String name) {
      if (name.length() > 5) {
         throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
      }
      this.name = name;
   }

   public Car (String name) {
      giveCarName(name);
      this.position = 0;
   }

   public void moveForward() {this.position++;}

   public String getName() {return this.name;}
   public int getPosition() {return this.position;}
}
