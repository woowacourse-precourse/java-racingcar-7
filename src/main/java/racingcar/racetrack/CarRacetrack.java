package racingcar.racetrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.racer.car.Car;
import racingcar.racer.RacerFactory;
import racingcar.io.CustomIO;

public class CarRacetrack implements Racetrack<Car> {
    CustomIO customIO = new CustomIO();
    RacerFactory racerFactory = new RacerFactory();

    public void run() {
        String[] names = customIO.inputCarNames();
        List<Car> cars = racerFactory.createCars(names);
        int repeat = customIO.inputRepeatNum();
        customIO.print("실행 결과");
        for (int i = 0; i < repeat; i++) {
            List<Car> moveResult = moveAll(cars);
            customIO.printResult(moveResult);
        }
        List<String> winners = findWinner(cars);
        customIO.printWinner(winners);
    }

    public List<Car> moveAll(List<Car> cars) {
        for (Car car : cars) {
            car.tryMove();
        }
        return cars;
    }

    public List<String> findWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        List<Integer> distanceList = new ArrayList<>();
        for (Car car : cars) {
            distanceList.add(car.getDistance().length());
        }
        Integer maxDistance = Collections.max(distanceList);
        for (Car car : cars) {
            if (car.getDistance().length() >= maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
