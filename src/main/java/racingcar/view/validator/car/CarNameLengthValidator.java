package racingcar.view.validator.car;

import static racingcar.common.constant.SystemConstant.CAR_NAME_MIN_LENGTH;
import static racingcar.util.PreprocessingUtil.stringToStringList;

import java.util.List;
import racingcar.common.exception.LengthExceedException;

public class CarNameLengthValidator extends CarNameInputValidator {

    private CarNameLengthValidator() {
    }

    public static CarNameLengthValidator initiate() {
        return new CarNameLengthValidator();
    }

    @Override
    public void check(final String source) {
        List<String> cars = stringToStringList(source);
        cars.forEach(name -> {
            if (exceedMinLength(name, CAR_NAME_MIN_LENGTH)) {
                throw new LengthExceedException(CAR_NAME_MIN_LENGTH);
            }
        });

        super.check(source);
    }

    private boolean exceedMinLength(String name, int length) {
        return name.length() > length;
    }
}
