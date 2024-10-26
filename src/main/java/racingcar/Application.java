package racingcar;

import racingcar.client.controller.FrontController;
import racingcar.config.SystemConfig;
import racingcar.middleware.dto.InputDTO;
import racingcar.middleware.dto.OutputDTO;
import racingcar.server.controller.ServerController;

public class Application {
    public static void main(String[] args) {
        SystemConfig systemConfig = SystemConfig.getInstance();
        FrontController frontController = systemConfig.initializeFrontController();
        ServerController serverController = systemConfig.initializeMainController();

        InputDTO inputs = frontController.readInputs();
        OutputDTO outputs = serverController.run(inputs);
        frontController.writeOutputs(outputs);
    }
}
