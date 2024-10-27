package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class CarController {
    // 자동차 이름을 car객체로 변환하여 리턴
    public List<Car> getCars(String input) {
        List<Car> cars = new ArrayList<>();
        List<String> carNames = extractCarName(input);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        // if cars.empty에 대한 예외 처리 추가하기
        return cars;
    }

    // 쉼표를 구분자로 이용하여 자동차 이름들을 추출
    public List<String> extractCarName(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
}
