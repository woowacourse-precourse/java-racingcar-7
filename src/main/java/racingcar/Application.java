package racingcar;

import racingcar.car.Car;
import racingcar.decider.Decider;
import racingcar.decider.FixedRatioDecider;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Decider decider = new FixedRatioDecider(4, 9);
        List<String> names = List.of("1", "2", "3");
        List<Car> cars = names.stream().map(name -> CarFactory.of(name, decider)).toList();
        CarGame game = new CarGame(5, cars);
        game.play();
    }
}
