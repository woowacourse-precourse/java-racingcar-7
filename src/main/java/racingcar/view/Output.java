package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceResult;

import java.util.List;

public class Output {
    public static void printRoundResult(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.print(car.getName() + " : ");
            printDash(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinner(Cars cars) {
        RaceResult raceResult = new RaceResult();
        List<Car> winner = raceResult.getWinner(cars);
        int winnerCount = 0;
        for (Car car : winner) {
            System.out.print(car.getName());
            winnerCount++;
            if (winnerCount < winner.size())
                System.out.print(", ");
        }
    }

    private static void printDash(int count) {
        for (int i = 0; i < count; i++)
            System.out.print("-");
    }
}
