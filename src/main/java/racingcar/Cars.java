package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    // TODO: 함수형으로 리팩토링
    public List<Integer> go(MoveCondition moveCondition) {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            int position = car.go(moveCondition);
            positions.add(position);
        }
        return positions;
    }
}
