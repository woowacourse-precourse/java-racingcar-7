package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Car> getCars() {
        String carNames;
        String[] splitCarNames;

        carNames = promptForCarNames();
        splitCarNames = carNames.split(",");
        Validator.validateCarNames(splitCarNames);
        return createCars(splitCarNames);
    }

    private static String promptForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<Car> createCars(String[] carNames) {
        List<Car> cars;

        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static int getGameCount() {
        String count;

        count = promptForGameCount();
        Validator.validateGameCount(count);
        return Integer.parseInt(count);
    }

    private static String promptForGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public static void main(String[] args) {
        List<Car> cars;
        int gameCount;
        Race race;

        cars = getCars();
        gameCount = getGameCount();
        race = new Race(cars);
        race.startRaceNTimes(gameCount);
    }
}
