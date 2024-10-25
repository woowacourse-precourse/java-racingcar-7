package racingcar;

import java.util.HashMap;
import racingcar.controller.RacingController;
import racingcar.domain.policy.RacingCarPolicy;
import racingcar.dto.RacingOutputDTO;
import racingcar.dto.ValidatedInputDataDTO;
import racingcar.repository.RacingCarRepository;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        RacingCarPolicy racingCarPolicy = new RacingCarPolicy();
        //TODO : 레이싱카의 정책을 inputView 가 갖고있는게 맞나..?
        ValidatedInputDataDTO validatedInputDataDTO = new RacingCarInputView().receiveInputData(racingCarPolicy);
        RacingCarService racingCarService = new RacingCarService(validatedInputDataDTO, racingCarPolicy,
                new RacingCarRepository(new HashMap<>()));
        RacingController racingController = new RacingController(racingCarService);
        RacingOutputDTO run = racingController.run();
        new RacingCarOutputView(run).printRacingResult();
    }
}
