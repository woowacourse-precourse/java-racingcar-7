package racingcar;

import java.util.List;

public class Output {

    public void printCurrentPositions(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMoveDisctance()));
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        int maxMoveDistance = cars.maxMoveDistance();
        List<String> winners = cars.findWinners(maxMoveDistance);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
