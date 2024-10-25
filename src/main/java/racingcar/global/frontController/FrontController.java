package racingcar.global.frontController;

import java.util.Set;
import racingcar.global.config.BeanConfig;
import racingcar.global.config.ProjectScanner;
import racingcar.racing.controller.RacingController;
import racingcar.racing.dto.request.RacingRequestDTO;
import racingcar.racing.dto.response.RacingResponseDTO;
import racingcar.racing.util.RacingRequestValidator;
import racingcar.racing.view.RacingRequestView;
import racingcar.racing.view.RacingResponseView;

public final class FrontController {

    static {
        ProjectScanner projectScanner = new ProjectScanner();
        Set<Class<?>> classesToBeBeans = projectScanner.getClassesForBeans();
        BeanConfig.registerBeanContainer(classesToBeBeans);
    }

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
