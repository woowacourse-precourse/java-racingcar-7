package racingcar.util;

import racingcar.dto.RacingInputReq;
import racingcar.message.ErrorMessage;
import racingcar.model.Car;
import racingcar.dto.RacingInfoDTO;
import java.math.BigInteger;
import java.util.List;

public class Validator {

    public RacingInfoDTO validInput(RacingInputReq racingInputReq) {
        Splitter separator = new Splitter();

        // 아무 값도 입력되지 않은 경우
        if (validBlank(racingInputReq.getCarNames(), racingInputReq.getRaceRounds())) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ARG.getMessage());
        }

        separator.splitSeparator(racingInputReq);

        // 시도할 횟수로 수가 아닌 값이 입력된 경우
        if (validNumber(racingInputReq.getRaceRounds())) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMBER.getMessage());
        }

        RacingInfoDTO racingInfoDTO = new RacingInfoDTO(separator.splitSeparator(racingInputReq), new BigInteger(racingInputReq.getRaceRounds()));

        // 자동차 이름 길이가 5보다 큰 경우
        if (validNameLength(racingInfoDTO.getCarList())) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH.getMessage());
        }

        return racingInfoDTO;
    }

    public Boolean validBlank(String carNames, String raceRounds) {
        return carNames.isBlank() || raceRounds.isBlank();
    }
    public Boolean validNumber(String raceRounds) {
        return !(raceRounds.matches("\\d+"));
    }

    public Boolean validNameLength(List<Car> carList) {
        for (Car car : carList) {
            if (car.getName().length() > 5) {
                return true;
            }
        }
        return false;
    }
}
