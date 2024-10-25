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

        try {
            Splitter separator = new Splitter(originInput.getCarNames());
            ProcessedInput processedInput = new ProcessedInput(separator.splitSeparator(), new BigInteger(originInput.getRaceRound()));
        }
        // 시도할 횟수로 수가 아닌 값이 입력된 경우
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMBER.getMessage());
        }
    }
}