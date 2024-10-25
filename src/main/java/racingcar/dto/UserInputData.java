package racingcar.dto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public record UserInputData(List<Car> cars, int tryCount) {
    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .forEach(winners::add);

        return winners;
    }

    public void startRacing() {
        for (int i = 0; i < tryCount; i++) {
            cars().stream()
                    .forEach((car)->car.tryMove(if60PercentChance()));
        }
    }

    private static boolean if60PercentChance() {
        int pickNumberInRange = Randoms.pickNumberInRange(0, 9);
        if (pickNumberInRange >= 4) {
            return true;
        }
        return false;
    }
}
