package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = getCars();
        int numberOfRounds = getNumberOfRounds();

        RacingGame racingGame = new RacingGame(cars, numberOfRounds);
        racingGame.startRace();
    }

    private static List<Car> getCars() {
        System.out.println("자동차 이름을 입력하세요 (쉼표로 구분): ");
        String input = Console.readLine();
        String[] names = input.split(",");

        InputValidator.validateCarNames(names);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static int getNumberOfRounds() {
        System.out.println("시도할 이동 횟수를 입력하세요: ");
        String input = Console.readLine();
        int rounds = Integer.parseInt(input);

        InputValidator.validateNumberOfRounds(rounds);

        return rounds;
    }
}
