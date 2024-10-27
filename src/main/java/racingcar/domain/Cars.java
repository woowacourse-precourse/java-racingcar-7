package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] players) {
        validDuplicate(players);
        this.cars = Arrays.stream(players)
                .map(Car::new)
                .toList();
    }

    private void validDuplicate(String[] players) {
        long duplicateCount = calculateDuplicate(players);
        if (duplicateCount >= 1) {
            throw new IllegalArgumentException("같은 이름을 사용할 수 없습니다");
        }
    }

    private long calculateDuplicate(String[] players) {
        return Arrays.stream(players)
                .filter(player -> Arrays.stream(players).filter(player::equals).count() > 1)
                .distinct()
                .count();
    }

    private static IntFunction<String> nameOfPlayer(String[] players) {
        return i -> getString(players, i);
    }

    private static String getString(String[] players, int i) {
        if (players[i].isEmpty()) {
            return String.format("%d 번째 선수", (i + 1));
        }
        return players[i];
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }


    public void tryMove(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generateNumber()));
    }

    public String getWinners() {
        int maxLocation = cars.stream().map(Car::getLocation).max(Integer::compareTo).get();
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
