package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Dto.CarData;

import java.util.List;

public class Car {
    private final String name;
    private int movedDistance = 0;

    public Car(String name) {
        validNameLength(name);
        validNameType(name);
        this.name = name;
    }

    private void validNameLength(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 다섯자 이내로 입력하세요.");
        }
    }
    private void validNameType(String name){
        if(name.chars().anyMatch(Character::isDigit)){
            throw new IllegalArgumentException("이름에 숫자가 포함되면 안됩니다.");
        }
    }
    public static void validateUniqueCarNames(List<Car> cars) {
        int uniqueCarNamesCount = (int)cars.stream()
                .map(car -> car.name)
                .distinct()
                .count();

        if (uniqueCarNamesCount != cars.size()) {
            throw new IllegalArgumentException("이름이 중복되면 안됩니다.");
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
