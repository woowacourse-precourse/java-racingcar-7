package racingcar;

import view.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarList {
    private final List<Car> carList = new ArrayList<>(); // 자동차 리스트

    public void add(String carName) {
        validateCarName(carName);
        carList.add(new Car(carName)); // 자동차 이름을 기반으로 Car 객체 생성 후 추가
    }

    private void validateCarName(String carName) {
        checkNull(carName);
        checkCarNameSize(carName);
    }

    private void checkCarNameSize(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_SIZE_ERROR.print());
        }
    }

    private void checkNull(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL_ERROR.print());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(carList); // 외부에서 수정할 수 없도록 리스트 반환
    }
}
