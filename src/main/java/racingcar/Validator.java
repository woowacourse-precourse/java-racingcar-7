package racingcar;

import java.util.List;

public class Validator {
    public void validateNameEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈 이름은 입력할 수 없습니다.");
        }
    }

    public void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 다섯 글자를 넘을 수 없습니다.");
        }
    }

    public void validateNameDuplicate(String name, List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().equals(name)) {
                throw new IllegalArgumentException("중복된 이름은 허용되지 않습니다.");
            }
        }
    }

    public void validatePositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("int 범위의 양수만 입력 가능합니다.");
        }
    }

    public void validateCountEmpty(String count) {
        if (count.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
        }
    }
}
