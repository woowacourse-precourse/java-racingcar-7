package racingcar.parser;

import java.util.Arrays;
import java.util.List;
import racingcar.dto.CarNameRequest;
import racingcar.dto.TryNumberRequest;
import racingcar.validation.InputValidator;

public class InputParser {

    public static CarNameRequest parseCarName(String carNames) {
        InputValidator.isCarNameNull(carNames);

        List<String> carNameList = Arrays.stream(carNames.split(","))
                .toList();

        InputValidator.isCarNameOverSize(carNameList);

        return CarNameRequest.of(carNameList);
    }

    public static TryNumberRequest parseTryNumber(String tryNumber) {
        InputValidator.isTryNumberNull(tryNumber);

        return TryNumberRequest.of(InputValidator.isTryNumberNotInt(tryNumber));
    }

}
