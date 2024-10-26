package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager { // TODO: 모델 이름 다시 생각해보기
    private List<Car> cars;

    public CarManager() {
        this.cars = new ArrayList<>();
    }

    public void initialize(List<String> names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public void advanceCars(List<Boolean> moveOrNot) {
        // TODO: isAdvance.size() == cars.size() 검증 해야되나?
        for (int i = 0; i < cars.size(); i++) {
            if (moveOrNot.get(i)) {
                cars.get(i).addMove();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        int max = findMax();
        return cars.stream()
                .filter(car -> car.getMove() == max)
                .collect(Collectors.toList()); // TODO: List<Car> or List<String> ??
    }

    private int findMax() {
        List<Integer> moves = pickMove();
        return moves.stream()
                .max(Integer::compareTo)
                .get();
    }

    private List<Integer> pickMove() {
        List<Integer> moves = new ArrayList<>();
        for (Car car : cars) { // TODO: cars 이렇게 써도 되나?
            moves.add(car.getMove());
        }
        return moves;
    }
}
