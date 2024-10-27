package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarController {
    private final RacingCarView view;

    public RacingCarController(RacingCarView racingCarView) {
        this.view = racingCarView;
    }

    public void play() {
        try {
            List<String> carNameList = view.getCarInput();
            List<Car> carList = createCarList(carNameList);

            int tryCount = view.getTryCountInput();

            for (int i = 0; i < tryCount; i++) {
                takeTurnOnce(carList);
            }

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void takeTurnOnce(List<Car> carList) {
        for(Car car : carList) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if(randomValue >= 4) {
                car.move();
            }
        }
    }

    // Car 객체 리스트 생성 함수
    private static List<Car> createCarList(List<String> carNames) {
        Set<String> checkUniqueName = new HashSet<>(); // 중복 이름 체크를 위함
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            if (!checkUniqueName.add(name)) { // 추가되지 않으면 중복 발생
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + name);
            }
            cars.add(new Car(name));
        }
        return cars;
    }
}
