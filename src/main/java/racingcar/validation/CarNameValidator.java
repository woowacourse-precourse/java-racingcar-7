package racingcar.validation;

import java.util.List;
import racingcar.domain.dto.CarsSaveRequestDto;
import racingcar.validation.exceptions.ValidationException;

/**
 * packageName    : racingcar.validation
 * fileName       : CarNameValidator
 * author         : ehgur
 * date           : 2024-10-25
 * description    : 자동차 이름 예외처리기
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-25        ehgur             최초 생성
 */

public class CarNameValidator {

    public static void run(CarsSaveRequestDto requestDto) {
        ValidationException.set.clear();
        List<String> carsName = requestDto.getNames();
        for (String name : carsName) {
            validateCarName(name);
        }
    }

    private static void validateCarName(String name) {
        ValidationException.isEmpty(name);
        ValidationException.isBlank(name);
        ValidationException.isCarNameLengthValid(name);
        ValidationException.isDuplicate(name);
    }

}
