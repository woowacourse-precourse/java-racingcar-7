package racingcar.controller;

import racingcar.message.ErrorMessage;
import racingcar.model.ProcessedInput;
import racingcar.model.OriginInput;
import racingcar.util.Splitter;
import racingcar.util.Validator;

import java.math.BigInteger;

public class RacingController {
    public void run() {
        /*
        입력, 레이싱, 최종 우승 자동차 출력 수행
        */
        OriginInput originInput = new OriginInput();
        Validator validator = new Validator();

        // 유저 입력 받기
        originInput.inputCarNames();
        originInput.inputRaceRounds();

        // 아무 값도 입력되지 않은 경우
        if (validator.validBlank(originInput.getCarNames(), originInput.getRaceRound())) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ARG.getMessage());
        }

        Splitter separator = new Splitter(originInput.getCarNames());

        // 시도할 횟수로 수가 아닌 값이 입력된 경우
        if (validator.validNumber(originInput.getRaceRound())) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMBER.getMessage());
        }

        ProcessedInput processedInput = new ProcessedInput(separator.splitSeparator(), new BigInteger(originInput.getRaceRound()));

        // 자동차 이름 길이가 5보다 큰 경우
        if (validator.validNameLength(processedInput.getCarList())) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH.getMessage());
        }
    }
}