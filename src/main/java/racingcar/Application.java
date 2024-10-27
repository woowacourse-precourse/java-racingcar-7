package racingcar;

import racingcar.model.Car;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        List<String> carNameList;
        try {
            carNameList = racingCarView.getCarInput();
            List<Car> carList = createCarList(carNameList);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    // Car 객체 리스트 생성 함수
    private static List<Car> createCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
