package racingcar.validator;

import java.util.List;
import racingcar.utils.CarNameParser;
import racingcar.validator.strategies.carnames.CarMinimumCountValidator;
import racingcar.validator.strategies.carnames.CarNameDuplicateValidator;
import racingcar.validator.strategies.carnames.CarNameListNotEmptyValidator;
import racingcar.validator.strategies.carnames.CarNameMaxLengthValidator;
import racingcar.validator.strategies.carnames.CarNameNotEmptyValidator;
import racingcar.validator.strategies.carnames.CarNameTrailingCommaValidator;

public class CarNameValidator {

    private final CarNameNotEmptyValidator carNameNotEmptyValidator;
    private final CarNameTrailingCommaValidator carNameTrailingCommaValidator;
    private final CarNameListNotEmptyValidator carNameListNotEmptyValidator;
    private final CarNameMaxLengthValidator carNameMaxLengthValidator;
    private final CarMinimumCountValidator carMinimumCountValidator;
    private final CarNameDuplicateValidator carNameDuplicateValidator;

    public CarNameValidator() {
        this.carNameNotEmptyValidator = new CarNameNotEmptyValidator();
        this.carNameTrailingCommaValidator = new CarNameTrailingCommaValidator();
        this.carNameListNotEmptyValidator = new CarNameListNotEmptyValidator();
        this.carNameMaxLengthValidator = new CarNameMaxLengthValidator();
        this.carMinimumCountValidator = new CarMinimumCountValidator();
        this.carNameDuplicateValidator = new CarNameDuplicateValidator();
    }

    public void validate(String carNames) {
        // 1. 전체 입력이 null 또는 빈 문자열인지 검증
        carNameNotEmptyValidator.validate(carNames);

        // 2. 마지막에 쉼표가 있는지 확인
        carNameTrailingCommaValidator.validate(carNames);

        List<String> nameList = CarNameParser.splitCarNames(carNames);

        // 3. 빈 항목을 포함하지 않는지 검증
        carNameListNotEmptyValidator.validate(nameList);

        // 4. 각 자동차 이름 길이 검증
        carNameMaxLengthValidator.validate(nameList);

        // 5. 최소 자동차 수 검증
        carMinimumCountValidator.validate(nameList);

        // 6. 중복 이름 검증
        carNameDuplicateValidator.validate(nameList);
    }

}
