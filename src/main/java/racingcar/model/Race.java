package racingcar.model;


import java.math.BigInteger;
import java.util.List;


public class Race {
   private List<Car> cars;
   private BigInteger attempts;


   public Race(List<Car> cars, BigInteger attempts) {
       this.cars = cars;
       this.attempts = attempts;
      
   }

}
