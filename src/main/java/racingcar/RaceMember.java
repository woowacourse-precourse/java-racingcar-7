package racingcar;

import java.util.List;

public class RaceMember {
    private final List<Car> raceMember;

    public RaceMember(List<String> carNames) {
        this.raceMember = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public void moveAll() {
        raceMember.forEach(Car::chanceToMove);
    }

    public List<Car> getRaceMember() {
        return raceMember;
    }

    public List<Car> getWinner() {
        int maxPosition = raceMember.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return raceMember.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();

    }
}
