package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        List<Car> cars = createCars(inputNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int rounds = readRounds();

        RaceGame raceGame = new RaceGame(cars, rounds);
        raceGame.play();
    }

    private static List<Car> createCars(String inputNames) {
        String[] names = inputNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static int readRounds() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
