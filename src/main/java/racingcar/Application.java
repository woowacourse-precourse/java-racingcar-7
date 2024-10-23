package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.factory.RacingCarFactory;
import racingcar.component.RacingCar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        RacingCarFactory racingCarFactory = new RacingCarFactory(input);
        List<RacingCar> racingCars = racingCarFactory.createRacingCars();
        RacingCar racingCar = racingCars.get(0);

        for (int i = 0; i < 5; i++) {
            racingCar.move();
        }

        Console.close();
    }
}
