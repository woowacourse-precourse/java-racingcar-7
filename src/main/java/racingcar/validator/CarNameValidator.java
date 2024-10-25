package racingcar.validator;

import java.util.List;
import racingcar.validator.strategies.carnames.DuplicateNameValidator;
import racingcar.validator.strategies.carnames.MinimumCarCountValidator;
import racingcar.validator.strategies.carnames.NameLengthValidator;
import racingcar.validator.strategies.carnames.NotNullOrEmptyValidator;

public class CarNameValidator {
    private final NotNullOrEmptyValidator notNullOrEmptyValidator;
    private final NameLengthValidator nameLengthValidator;
    private final DuplicateNameValidator duplicateNameValidator;
    private final MinimumCarCountValidator minimumCarCountValidator;

    public CarNameValidator() {
        this.notNullOrEmptyValidator = new NotNullOrEmptyValidator();
        this.nameLengthValidator = new NameLengthValidator();
        this.duplicateNameValidator = new DuplicateNameValidator();
        this.minimumCarCountValidator = new MinimumCarCountValidator();
    }


    public void validate(String carNames) {
        // null 또는 빈 문자열 검증
        notNullOrEmptyValidator.validate(carNames);

        // 쉼표 기준으로 이름 분리
        List<String> nameList = List.of(carNames.split(","));

        // 각 자동차 이름 길이 검증
        nameList.forEach(nameLengthValidator::validate);

        // 최소 자동차 수 검증
        minimumCarCountValidator.validate(nameList);

        // 중복 이름 검증
        duplicateNameValidator.validate(nameList);
    }

}
