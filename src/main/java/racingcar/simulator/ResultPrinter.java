package racingcar.simulator;

import java.util.List;
import java.util.Map;
import racingcar.car.Car;

public class ResultPrinter {

    public void printResultOfForward(Map<Integer, Car> carMap, int[] racingBoard) {
        StringBuilder resultOfForward = new StringBuilder();
        for (int carId = 0; carId < racingBoard.length; carId++) {
            Car car = carMap.get(carId);
            resultOfForward.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(racingBoard[carId]))
                    .append("\n");
        }
        System.out.println(resultOfForward);
    }

    public void printResultOfWinners(List<Car> winners) {
        List<String> namesOfWinners = winners.stream().map(Car::getName).toList();
        String resultOfWinners = String.join(", ", namesOfWinners);

        System.out.println(resultOfWinners);
    }
}
