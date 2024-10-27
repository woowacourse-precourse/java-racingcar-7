package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static racingcar.CarNames.createCarNames;
import static racingcar.WinnerCalculator.calculateWinners;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int raceTime = Integer.parseInt(Console.readLine());

        List<String> carNames = createCarNames(carName);
        Cars cars = new Cars(carNames);

        System.out.println("실행 결과");
        List<List<Car>> raceRecords = cars.race(raceTime);
        for (List<Car> raceRecord : raceRecords) {
            for (Car car : raceRecord) {
                System.out.println(car.toCustomFormatString("-"));
            }
            System.out.println();
        }

        List<Car> lastRacingRecord = raceRecords.getLast();
        List<String> winnerNames = calculateWinners(lastRacingRecord);
        String winnerRecord = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winnerRecord);
    }
}
