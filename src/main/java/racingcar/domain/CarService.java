package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarService {
    private static final int CAR_MOVE_CONDITION = 4;
    private static StringBuilder stringBuilder = new StringBuilder();

    public void progressGame(List<Car> cars, int tryNumber) {
        while (tryNumber-- > 0) {
            moveCarsIfConditionMet(cars);
            updateIntermediateResult(cars);
        }
    }

    private void moveCarsIfConditionMet(List<Car> cars) {
        for (Car car : cars) {
            if (RandomNumber.getRandomNumber() >= CAR_MOVE_CONDITION) {
                car.move();
            }
        }
    }

    public StringBuilder getIntermediateResult() {
        return stringBuilder;
    }

    public void updateIntermediateResult(List<Car> cars) {
        for (Car car : cars) {
            stringBuilder.append(car.getName() + " : " + getPositionOutPut(car.getPosition()) + "\n");
        }
        stringBuilder.append("\n");
    }

    private String getPositionOutPut(int carPosition) {
        String positionOutPut = "";
        for (int i = 0; i < carPosition; i++) {
            positionOutPut += "-";
        }
        return positionOutPut;
    }

    public List<Car> makeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> getWinners(List<Car> cars) {
        Optional<Integer> maxDistanceOptional = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo);

        int maxDistance = maxDistanceOptional.get();

        return cars.stream()
                .filter(car -> car.getPosition() == maxDistance)
                .toList();
    }

}
