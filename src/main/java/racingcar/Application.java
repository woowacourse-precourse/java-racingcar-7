package racingcar;

import racingcar.domain.CarRacing;
import racingcar.domain.RacingCarPolicy;
import racingcar.dto.ValidatedInputDataDTO;
import racingcar.infrastructure.RacingCarHistory;
import racingcar.presentation.RacingCarInputView;
import racingcar.presentation.RacingCarOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarPolicy racingCarPolicy = new RacingCarPolicy();
        //TODO : 레이싱카의 정책을 inputView 가 갖고있는게 맞나..?
        ValidatedInputDataDTO validatedInputDataDTO = new RacingCarInputView().receiveInputData(racingCarPolicy);
        CarRacing carRacing = new CarRacing(validatedInputDataDTO, racingCarPolicy, new RacingCarHistory());
        new RacingCarOutputView(carRacing.racingStart()).printRacingResult();
    }
}
