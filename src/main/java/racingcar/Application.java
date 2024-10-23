package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Condition;
import racingcar.domain.RandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        Condition condition = new Condition(new RandomNumberGenerator());
        Car car = new Car("car", condition);
        car.forward();
        System.out.println(car.getName() + ": " + "-".repeat(car.getPosition()));
    }

}
