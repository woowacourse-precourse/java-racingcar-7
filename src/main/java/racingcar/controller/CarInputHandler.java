package racingcar.controller;

import racingcar.model.Car;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

/**
 * CarInputHandler 클래스는 자동차 이름 입력을 받아 유효성을 검증하고,
 * Car 객체 리스트를 생성하여 반환하는 역할을 수행합니다.
 */
public class CarInputHandler {

    /**
     * 사용자로부터 입력받은 자동차 이름을 통해 Car 객체 리스트를 생성합니다.
     * 입력받은 이름들은 공백을 제거하고, 유효성을 검증한 후 Car 객체로 변환됩니다.
     *
     * @return 생성된 Car 객체 리스트
     */
    public List<Car> getCarNames() {
        // 사용자로부터 자동차 이름 입력받기
        String carNames = InputView.inputCarNames();

        // 자동차 이름 유효성 검사
        CarNameValidator.validateCarNames(carNames);

        // 입력받은 이름 문자열을 쉼표(,)로 구분하여 배열로 변환
        String[] names = carNames.split(",");

        // 각 이름을 Car 객체로 변환하여 리스트에 추가
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim())); // 공백 제거 후 Car 객체 생성
        }

        return cars;
    }
}
