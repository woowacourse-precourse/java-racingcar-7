package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Dto.CarData;

import java.util.List;

public class Car {
    private final String name;
    private int movedDistance = 0;

    public Car(String name) {
        validNameLength(name);
        this.name = name;
    }

    private void validNameLength(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 다섯자 이내로 입력하세요");
        }
    }


    public void move() {
        if (canMove()) {
            movedDistance++;
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }

    public CarData getCurrentCarData() {
        return new CarData(name, movedDistance);
    }

    public String getName() {
        return name;
    }

    public static int findMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.movedDistance)
                .max()
                .getAsInt();
    }

    public boolean isSameDistance(int distance) {
        return distance == movedDistance;
    }
}
