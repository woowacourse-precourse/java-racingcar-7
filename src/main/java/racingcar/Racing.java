package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private static Car[] cars;

    public Racing(String[] carNames) {
        cars = new Car[carNames.length];
        int i = 0;
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                cars[i] = new Car("NoName");
            } else {
                cars[i] = new Car(carName);
            }
            i++;
        }
    }

    public Car[] getCars() {
        return cars;
    }

    public void runRound() {
        for (Car car : cars) {
            car.addDist();
        }
        Output.printRoundResult(cars);
        System.out.println();
    }

    public void runAllRound(int round) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            runRound();
        }
    }

    public List<String> findLongestDistance(Car[] cars) {
        List<String> longestDistanceCar = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : cars) {
            int dist = car.getDist().length();
            if (dist > maxDistance) {
                maxDistance = dist;
                longestDistanceCar.clear();
                longestDistanceCar.add(car.getName());
            } else if (dist == maxDistance) {
                longestDistanceCar.add(car.getName());
            }
        }
        return longestDistanceCar;
    }

    public void getWinner() {
        String winners = String.join(", ", findLongestDistance(cars));
        Output.printWinner(winners);
    }
}
