package racingcar.controller;

import racingcar.dto.RaceRequest;
import racingcar.service.ValidationService;
import racingcar.view.View;

public class RaceProxy implements Controller<RaceRequest> {

    private Controller<RaceRequest> controller;
    private ValidationService validationService;

    public RaceProxy(Controller<RaceRequest> controller) {
        this.validationService = new ValidationService();
        this.controller = controller;
    }

    @Override
    public View run(RaceRequest request) {
        validationService.verifyInput(request.getCarInput());
        return controller.run(request);
    }
}
