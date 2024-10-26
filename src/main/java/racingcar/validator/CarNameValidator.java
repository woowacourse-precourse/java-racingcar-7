package racingcar.validator;

import java.util.List;
import racingcar.util.CarNameUtils;
import racingcar.validator.strategies.carnames.CarNameNotEmptyInListValidator;
import racingcar.validator.strategies.carnames.CarNameNotEmptyValidator;
import racingcar.validator.strategies.carnames.DuplicateNameValidator;
import racingcar.validator.strategies.carnames.MinimumCarCountValidator;
import racingcar.validator.strategies.carnames.NameLengthValidator;
import racingcar.validator.strategies.carnames.TrailingCommaValidator;

public class CarNameValidator {

    private final CarNameNotEmptyValidator carNameNotEmptyValidator;
    private final TrailingCommaValidator trailingCommaValidator;
    private final CarNameNotEmptyInListValidator carNameNotEmptyInListValidator;
    private final NameLengthValidator nameLengthValidator;
    private final MinimumCarCountValidator minimumCarCountValidator;
    private final DuplicateNameValidator duplicateNameValidator;

    public CarNameValidator() {
        this.carNameNotEmptyValidator = new CarNameNotEmptyValidator();
        this.trailingCommaValidator = new TrailingCommaValidator();
        this.carNameNotEmptyInListValidator = new CarNameNotEmptyInListValidator();
        this.nameLengthValidator = new NameLengthValidator();
        this.minimumCarCountValidator = new MinimumCarCountValidator();
        this.duplicateNameValidator = new DuplicateNameValidator();
    }

    public void validate(String carNames) {
        // 1. 전체 입력이 null 또는 빈 문자열인지 검증
        carNameNotEmptyValidator.validate(carNames);

        // 2. 마지막에 쉼표가 있는지 확인
        trailingCommaValidator.validate(carNames);

        // 3. carNames를 리스트로 분리하여 모든 Validator에 전달
        List<String> nameList = CarNameUtils.splitCarNames(carNames);

        // 4. 빈 항목을 포함하지 않는지 검증
        carNameNotEmptyInListValidator.validate(nameList);

        // 5. 각 자동차 이름 길이 검증
        nameLengthValidator.validate(nameList);

        // 6. 최소 자동차 수 검증
        minimumCarCountValidator.validate(nameList);

        // 7. 중복 이름 검증
        duplicateNameValidator.validate(nameList);
    }

}
