package racingcar.factory.controller;

import java.util.HashMap;
import java.util.Map;
import racingcar.controller.Controller;
import racingcar.controller.RaceController;
import racingcar.controller.RaceProxy;
import racingcar.dto.RaceRequest;
import racingcar.factory.Factory;

public class ControllerFactory implements Factory<Controller<RaceRequest>> {

    private Map<String, Controller<RaceRequest>> controllerMap;

    public ControllerFactory() {
        controllerMap = new HashMap<>();
        controllerMap.put(ControllerType.RACE, new RaceController());
    }

    @Override
    public Controller<RaceRequest> create(String type) {
        Controller<RaceRequest> controller = controllerMap.getOrDefault(type, null);
        return new RaceProxy(controller);
    }
}
