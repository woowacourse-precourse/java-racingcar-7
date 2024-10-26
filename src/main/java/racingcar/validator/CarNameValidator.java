package racingcar.validator;

import java.util.List;
import racingcar.util.CarNameUtils;
import racingcar.validator.strategies.carnames.CarNameDuplicateValidator;
import racingcar.validator.strategies.carnames.CarNameListNotEmptyValidator;
import racingcar.validator.strategies.carnames.CarNameNotEmptyValidator;
import racingcar.validator.strategies.carnames.CarNameTrailingCommaValidator;
import racingcar.validator.strategies.carnames.MaximumCarNameLengthValidator;
import racingcar.validator.strategies.carnames.MinimumNumberOfCarsValidator;

public class CarNameValidator {

    private final CarNameNotEmptyValidator carNameNotEmptyValidator;
    private final CarNameTrailingCommaValidator carNameTrailingCommaValidator;
    private final CarNameListNotEmptyValidator carNameListNotEmptyValidator;
    private final MaximumCarNameLengthValidator maximumCarNameLengthValidator;
    private final MinimumNumberOfCarsValidator minimumNumberOfCarsValidator;
    private final CarNameDuplicateValidator carNameDuplicateValidator;

    public CarNameValidator() {
        this.carNameNotEmptyValidator = new CarNameNotEmptyValidator();
        this.carNameTrailingCommaValidator = new CarNameTrailingCommaValidator();
        this.carNameListNotEmptyValidator = new CarNameListNotEmptyValidator();
        this.maximumCarNameLengthValidator = new MaximumCarNameLengthValidator();
        this.minimumNumberOfCarsValidator = new MinimumNumberOfCarsValidator();
        this.carNameDuplicateValidator = new CarNameDuplicateValidator();
    }

    public void validate(String carNames) {
        // 1. 전체 입력이 null 또는 빈 문자열인지 검증
        carNameNotEmptyValidator.validate(carNames);

        // 2. 마지막에 쉼표가 있는지 확인
        carNameTrailingCommaValidator.validate(carNames);

        // 3. carNames를 리스트로 분리하여 모든 Validator에 전달
        List<String> nameList = CarNameUtils.splitCarNames(carNames);

        // 4. 빈 항목을 포함하지 않는지 검증
        carNameListNotEmptyValidator.validate(nameList);

        // 5. 각 자동차 이름 길이 검증
        maximumCarNameLengthValidator.validate(nameList);

        // 6. 최소 자동차 수 검증
        minimumNumberOfCarsValidator.validate(nameList);

        // 7. 중복 이름 검증
        carNameDuplicateValidator.validate(nameList);
    }

}
