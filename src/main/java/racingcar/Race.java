package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private String[] carNames;
    private int trialCount;
    private Map<String, Car> carMap;

    public Race(String[] carNames, int trialCount) {
        this.carNames = carNames;
        this.trialCount = trialCount;
        this.carMap = initializeCarMap();
    }

    private Map<String, Car> initializeCarMap() {
        Map<String, Car> map = new HashMap<>();
        for (String carName : carNames) {
            map.put(carName.trim(), new Car(carName.trim()));
        }
        return map;
    }

    public void simulate() {
        for (int i = 0; i < trialCount; i++) {
            for (Car car : carMap.values()) {
                car.move();
                printCarPosition(car);
            }
            System.out.println();
        }
    }

    private void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + car.getPositionString());
    }

    public void printWinner() {
        int maxPosition = findMaxPosition();
        List<String> winners = findWinners(maxPosition);
        String winner = String.join(",", winners);
        System.out.println("최종 우승자 : " + winner);
    }

    private int findMaxPosition() {
        return carMap.values().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<String> findWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : carMap.values()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
