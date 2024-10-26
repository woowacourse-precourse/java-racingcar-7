package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> winners = calculateWinners(lastRacingRecord);

        String winnerRecord = String.join(", ", winners);
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

    public static List<String> calculateWinners(List<Car> lastRacingRecord) {
        List<String> winners = new ArrayList<>();

        int max = calculateMaxPosition(lastRacingRecord);
        for (Car car : lastRacingRecord) {
            winners.addAll(car.addIfWinner(max));
        }

        return winners;
    }

    public static int calculateMaxPosition(List<Car> lastRacingRecord) {
        int max = Integer.MIN_VALUE;
        for (Car lastRacingRecordCar : lastRacingRecord) {
            max = lastRacingRecordCar.calculateMaxPosition(max);
        }

        return max;
    }
}
