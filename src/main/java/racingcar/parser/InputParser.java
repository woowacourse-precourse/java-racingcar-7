package racingcar.parser;

import java.util.Arrays;
import java.util.List;
import racingcar.dto.CarNameRequest;
import racingcar.dto.TryNumberRequest;
import racingcar.validation.CarNameValidator;

public class InputParser {

    public static CarNameRequest parseCarName(String carNames) {
        CarNameValidator.isNull(carNames);

        List<String> carNameList = Arrays.stream(carNames.split(","))
                .toList();

        CarNameValidator.isOverSize(carNameList);

        return CarNameRequest.of(carNameList);
    }

    public static TryNumberRequest parseTryNumber(String tryNumber) {
        // TODO tryNumber 유효성 검증
        return TryNumberRequest.of(Integer.parseInt(tryNumber));
    }

}
