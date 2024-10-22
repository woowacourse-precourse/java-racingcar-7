package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        validateParticipantsCount(cars);
        this.cars.clear();
        this.cars.addAll(cars);
    }

    private void validateParticipantsCount(List<Car> cars) {
        if (cars.isEmpty() || cars.size() > 1000) {
            throw new IllegalArgumentException("자동차 경주 게임에 참여하는 자동차는 1대 이상, 1000 대 이하여야 합니다.");
        }
    }
}
