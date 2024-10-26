package racingcar.parser;

import java.util.Arrays;
import java.util.List;
import racingcar.dto.CarNameRequest;

public class CarNameParser {

    public static CarNameRequest parseCarName(String carNames) {
        // TODO CarNames 유효성 검증
        List<String> carNameList = Arrays.stream(carNames.split(","))
                .toList();
        return CarNameRequest.of(carNameList);
    }

}
