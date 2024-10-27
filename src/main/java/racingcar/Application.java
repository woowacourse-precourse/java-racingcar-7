package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static racingcar.CarNames.createCarNames;
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
}
