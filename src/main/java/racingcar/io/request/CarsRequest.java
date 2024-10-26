package racingcar.io.request;

import java.util.regex.Pattern;

public record CarsRequest(
    String nameOfCars
) {

    public static final String CAR_NAME_SPLIT_DELIMITER = ",";
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[가-힣a-zA-Z0-9]+(" + CAR_NAME_SPLIT_DELIMITER + "[가-힣a-zA-Z0-9]+)*$");

    public CarsRequest {
        validateCarNames(nameOfCars);
    }

    private void validateCarNames(final String nameOfCars) {
        if (nameOfCars == null || nameOfCars.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (!CAR_NAME_PATTERN.matcher(nameOfCars).matches()) {
            throw new IllegalArgumentException("자동차 이름과 쉼표만 입력해주세요. 공백은 사용 할 수 없습니다.");
        }
    }
}
