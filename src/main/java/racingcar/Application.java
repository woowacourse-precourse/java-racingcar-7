package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.WinnerCalculator.calculateWinners;

public class Application {
    public static void main(String[] args) {
        String carName = Console.readLine();
        int raceTime = Integer.parseInt(Console.readLine());

        List<String> carNames = createCarNames(carName);
        Cars cars = new Cars(carNames);

        List<List<Car>> raceRecords = cars.race(raceTime);
        for (List<Car> raceRecord : raceRecords) {
            for (Car car : raceRecord) {
                System.out.println(car.toString());
            }
        }

        List<Car> lastRacingRecord = raceRecords.getLast();
        List<String> winnerNames = calculateWinners(lastRacingRecord);
        String winnerRecord = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winnerRecord);
    }

    public static List<String> createCarNames(String carName) {
        List<String> carNames = Arrays.stream(carName.split(","))
                .toList();

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(name + "이름이 5자리가 넘습니다");
            }
        }

        return carNames;
    }
}
