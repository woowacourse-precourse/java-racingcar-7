package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = Input.getCarNames();
        int runLimit = Input.getRunLimit();
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        RacingGame game = new RacingGame(cars, runLimit);
        System.out.println("\n실행 결과");
        game.run();
        game.printWinners();
    }
}
