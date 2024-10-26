package racingcar.view;

import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String EMPTY_CAR_NAME = "이름이 빈 값 입니다.";
    private static final String CANNOT_CONVERT_INTO_INT_ERROR = "입력하신 시도할 횟수를 int로 변환할 수 없습니다.";

    public List<String> scanCarNames(){
        String carNameString = readLine();
        List<String> carNames = Arrays.asList(carNameString.split(CAR_NAME_DELIMITER));
        isValidNames(carNames);
        return carNames;
    }

    private void isValidNames(List<String> carNames){
        if(carNames.isEmpty()){
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
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
