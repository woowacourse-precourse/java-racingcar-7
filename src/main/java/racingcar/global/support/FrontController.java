package racingcar.global.support;

import racingcar.racing.controller.RacingController;
import racingcar.racing.dto.request.RacingRequestDTO;
import racingcar.racing.dto.response.RacingResponseDTO;
import racingcar.racing.util.RacingRequestValidator;
import racingcar.racing.view.RacingRequestView;
import racingcar.racing.view.RacingResponseView;

public final class FrontController {

    private void racingRequestHandling() {
        RacingController racingController = BeanConfig.getBean(RacingController.class);

        RacingRequestDTO request = RacingRequestView.request();
        RacingRequestValidator.validateRacingRequest(request);

        RacingResponseDTO racingResult = racingController.racing(request);

        RacingResponseView.response(racingResult);
    }

    public void run() {
        racingRequestHandling();
    }
}
