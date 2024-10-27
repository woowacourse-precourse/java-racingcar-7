package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String inputCarName = Input.carName();
        List<String> carNameList = Validate.carName(inputCarName);

        String inputAttempts = Input.attempts();
        int attempts = Validate.attempts(inputAttempts);

        List<Car> carList = Car.makeCar(carNameList);
        Output.playRacing();
        playRacing(attempts, carList);

        List<String> winners = selectWinners(carList);
        Output.result(winners);
    }

    private static void playRacing(int attempts, List<Car> carList) {
        for (int i = 0; i < attempts; i++) {
            race(carList);
            printCars(carList);
        }
    }

    private static void race(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    private static void printCars(List<Car> carList) {
        for (Car car : carList) {
            int position = car.getPosition();
            String carName = car.getName();
            System.out.println(carName + " : " + "-".repeat(position));
        }

        System.out.println();
    }

    private static List<String> selectWinners(List<Car> carList) {
        int maxPosition = 0;

        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}