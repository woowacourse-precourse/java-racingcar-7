package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameHandler {

    // ','로 차 이름 분리 및 공백 제거
    private List<String> splitCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    // Car 객체 생성 및 차 이름 저장
    public CarData storeCar(String input) {
        List<String> carNames = splitCarNames(input);
        CarData carData = new CarData();
        carData.setCarNames(carNames);
        return carData;
    }
}