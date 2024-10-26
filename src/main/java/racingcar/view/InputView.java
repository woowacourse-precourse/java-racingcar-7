package racingcar.view;

import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String CANNOT_CONVERT_INTO_INT_ERROR = "입력하신 시도할 횟수를 int로 변환할 수 없습니다.";

    public List<String> scanCarNames(){
        String carNameString = readLine();
        return Arrays.asList(carNameString.split(CAR_NAME_DELIMITER));
    }

    public int scanTryCount() {
        try {
            String stringTryCount = readLine();
            return Integer.parseInt(stringTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CANNOT_CONVERT_INTO_INT_ERROR);
        }
    }
}
