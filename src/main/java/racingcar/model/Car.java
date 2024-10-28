package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Car {
    public static List<String> getCar(String cars) {
        return new ArrayList<>(Arrays.asList(cars.split(",")));
    }

    public static List<Integer> getCarPositions(List<String> carNames) {
        return new ArrayList<>(Collections.nCopies(carNames.size(), 0)); // 초기값 0으로 설정하여 바로 반환
    }
}
