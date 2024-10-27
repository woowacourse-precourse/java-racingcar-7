package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static racingcar.WinnerCalculator.calculateWinners;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int raceTime = Integer.parseInt(Console.readLine());

        CarNames carNames = new CarNames(carName);
        Cars cars = new Cars(carNames.createCars());

        System.out.println("실행 결과");
        List<Car> racingCars = race(raceTime, cars);

        List<String> winnerNames = calculateWinners(racingCars);
        String winnerRecord = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winnerRecord);
    }

    public static List<Car> race(int raceTime, Cars cars) {
        List<Car> movingCars = null;
        for (int i = 0; i < raceTime; i++) {
            movingCars = moveCars(cars);
        }

        return movingCars;
    }

    private static List<Car> moveCars(Cars cars) {
        List<Car> racingCars = cars.moveCars();
        for (Car racingCar : racingCars) {
            System.out.println(racingCar.toCustomFormatString("-"));
        }
        System.out.println();

        return racingCars;
    }
}
