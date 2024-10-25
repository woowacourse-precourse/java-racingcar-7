package racingcar.contorller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.PrintMessage;

public class RacingCarPlay {

    private static final PrintMessage message = new PrintMessage();

    public static void play() {
        message.printStartMessage();
        String input = Console.readLine();
        InputValidator.nullValidate(input);
        String[] carNames = input.split(",");
        InputValidator.lenValidate(carNames);
        List<Car> cars = createCars(carNames);

        message.printAttemptsMessage();
        int attempts = Integer.parseInt(Console.readLine());
        InputValidator.attemptsValidate(attempts);

        message.printResultMessage();
        for (int i = 0; i < attempts; i++) {
            currentGamePlay(cars);
        }
    }


    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static void currentGamePlay(List<Car> cars) {
        for (Car car : cars) {
            car.setPlayGameScore(Randoms.pickNumberInRange(0,9));
            if(car.getPlayGameScore() > 3) {
                car.incrementGameTotalScore();
            }
            System.out.println(car.getCarName() + " : " + car.getProgressDisplay());
        }
        System.out.println();
    }
}
