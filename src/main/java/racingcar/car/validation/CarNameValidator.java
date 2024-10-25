package racingcar.car.validation;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import racingcar.car.exception.CarNameException;
import racingcar.common.ExceptionEnum;

//Stirng[] 배열 사용에 대해서 고민하기!!!

// 자동차 이름 검증 클래스
public class CarNameValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final Set<String> carNames = new HashSet<>(); // 중복 체크를 위한 Set

    // 자동차 이름 검증 메서드
    public void validateCarName(String CarName) {
        if (CarName == null || CarName.trim().isEmpty()) {
            throw new CarNameException(ExceptionEnum.EMPTY_CAR_NAME.getMessage());
        }

        if (CarName.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarNameException(ExceptionEnum.INVALID_CAR_NAME_LENGTH.getMessage());
        }

        if (carNames.contains(CarName)) {
            throw new CarNameException(ExceptionEnum.DUPLICATE_CAR_NAME.getMessage());
        }

        if (!isValidCarNameFormat(CarName)) {
            throw new CarNameException(ExceptionEnum.INVALID_CAR_NAME_FORMAT.getMessage());
        }

        carNames.add(CarName); // 중복 체크를 위해 이름 저장
    }

    // 자동차 이름 형식 검증 (특수문자, 한글, 숫자 포함 여부)
    private boolean isValidCarNameFormat(String CarName) {
        String regex = "^[a-zA-Z]+$"; // 영어 알파벳만 허용
        return Pattern.matches(regex, CarName);
    }
}