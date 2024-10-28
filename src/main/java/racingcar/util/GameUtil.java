package racingcar.util;

import racingcar.domain.Car;
import racingcar.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class GameUtil {

    /**
     * ","를 기준으로 자동차 이름을 잘라주는 메서드
     * @param inputCarName 자동차 이름을 입력 받은 문자열
     * @return ","를 기준으로 잘라진 자동차 이름들
     */
    public static List<String> prepareCarNames(String inputCarName) {
        List<String> carNames = Arrays.asList(inputCarName.split(",", -1));
        Validator.checkDuplicateNames(carNames);
        return carNames;
    }

    /**
     * 가장 많이 이동한 자동차를 계산해주는 함수
     * @param cars 경주한 자동차
     * @return 우승한 자동차
     */
    public static List<String> calculateWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName).toList();
    }
}
