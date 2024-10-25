package racingcar.model;


import java.math.BigInteger;


public class Car {
   private String name;
   private BigInteger position;
   private boolean isWinner;


   public Car(String name) {
       this.name = name;
       this.position = BigInteger.ZERO;
       this.isWinner = false;
      
   }


   public void move() {
       this.position = this.position.add(BigInteger.ONE);
   }


   public BigInteger getPosition() {
       return this.position;
   }


   public String getName() {
       return this.name;
   }
}
