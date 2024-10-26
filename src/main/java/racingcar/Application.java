package racingcar;

import racingcar.app.front.controller.FrontController;
import racingcar.app.middleware.dto.InputDTO;
import racingcar.app.middleware.dto.OutputDTO;
import racingcar.app.server.controller.ServerController;
import racingcar.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        FrontController frontController = appConfig.initializeFrontController();
        ServerController serverController = appConfig.initializeServerController();

        InputDTO inputs = frontController.readInputs();
        OutputDTO outputs = serverController.run(inputs);
        frontController.writeOutputs(outputs);
    }
}
