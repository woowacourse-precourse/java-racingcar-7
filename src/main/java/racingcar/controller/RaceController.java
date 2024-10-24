package racingcar.controller;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;


public class RaceController {
   public void startRace() {
       List<Car> cars = createCars(getCarNames());
       BigInteger attempts = InputView.getAttempts();
       runRace(cars, attempts);
   }


   private String getCarNames() {
       return InputView.getCarNames();
   }


   private void runRace(List<Car> cars, BigInteger attempts) {


   }


   private List<Car> createCars(String carNames) {
       String[] names = carNames.split(",");
       List<Car> cars = new ArrayList<>();


       for (String name : names) {
           name = name.trim();
           validateCarName(name);


           cars.add(new Car(name));
       }


       return cars;
   }


   private void validateCarName(String name) {
       if (name.isEmpty()) {
           throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
       }
       if (name.length() > 5) {
           throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
       }
   }
}