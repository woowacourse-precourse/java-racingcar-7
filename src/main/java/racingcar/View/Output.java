package racingcar.View;

import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.List;

public class Output {
    public static void validatorCarNames(String carName) {
        if(carName.length() > 5 || carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void printMoveStatus(Car car) {
        StringBuilder status = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getMovestatus(); i++) {
            status.append("-");
        }
        System.out.println(status);
    }

    public static List<Car> checkWinner(List<Car> cars) {
        List<Car> carsMaxStateoOfMove = new ArrayList<>();
        int maxStateofmove = Integer.MIN_VALUE;

        for (Car car : cars) {
            int stateOfMove = car.getMovestatus();
            if (stateOfMove > maxStateofmove) {
                maxStateofmove = stateOfMove;
                carsMaxStateoOfMove.clear();
                carsMaxStateoOfMove.add(car);
            } else if (stateOfMove == maxStateofmove) {
                carsMaxStateoOfMove.add(car);
            }
        }
        return carsMaxStateoOfMove;
    }

    public static void printWinner(List<Car> winnersCars) {
        StringBuilder winnersCarOutput = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winnersCars.size(); i++) {
            if(i > 0) {
                winnersCarOutput.append(", ");
            }
            winnersCarOutput.append(winnersCars.get(i).getName());
        }
        System.out.println(winnersCarOutput);
    }
}