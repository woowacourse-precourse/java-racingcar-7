package racingcar.parser;

import java.util.Arrays;
import java.util.List;
import racingcar.dto.CarNameRequest;
import racingcar.validation.CarNameValidator;

public class CarNameParser {

    public static CarNameRequest parseCarName(String carNames) {
        CarNameValidator.isNull(carNames);

        List<String> carNameList = Arrays.stream(carNames.split(","))
                .toList();

        CarNameValidator.isOverSize(carNameList);

        return CarNameRequest.of(carNameList);
    }

}
