package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarFactory {

    /**
     * 입력된 문자열을 바탕으로 RacingCar 객체 리스트를 생성한다.
     * @param input 콤마로 구분된 자동차 이름 문자열
     * @return 생성된 RacingCar 객체 리스트
     * @throws IllegalArgumentException 입력 값이 비어있거나, 이름이 중복 또는 5자 초과일 경우 발생
     */
    public static List<RacingCar> createCars(String input) {
        validateInput(input);

        String[] carNames = input.split(",");
        validateUniqueNames(carNames);

        return Arrays.stream(carNames)
                .map(String::trim)
                .map(CarFactory::createCar)
                .toList();
    }

    /**
     * 입력 값이 null 또는 빈 문자열인지 검증한다.
     * @param input 자동차 이름 입력 문자열
     * @throws IllegalArgumentException 입력이 비어있을 경우 발생
     */
    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 입력이 비어있습니다.");
        }
    }

    /**
     * 자동차 이름 배열에서 중복 이름이 있는지 검증한다.
     * @param carNames 자동차 이름 배열
     * @throws IllegalArgumentException 중복된 이름이 있을 경우 발생
     */
    private static void validateUniqueNames(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String carName : carNames) {
            carName = carName.trim();
            if (!uniqueNames.add(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다: " + carName);
            }
        }
    }

    /**
     * 자동차 이름의 길이를 검증하고, 유효하면 RacingCar 객체를 생성한다.
     * @param carName 생성할 자동차 이름
     * @return 생성된 RacingCar 객체
     * @throws IllegalArgumentException 이름이 5자 초과일 경우 발생
     */
    private static RacingCar createCar(String carName) {
        carName = carName.trim();
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요: " + carName);
        }
        return new RacingCar(carName, 0, "-");
    }
}
