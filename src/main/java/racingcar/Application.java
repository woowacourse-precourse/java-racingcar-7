package racingcar;

import racingcar.application.port.inbound.InboundAdapter;
import racingcar.infrastructure.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        InboundAdapter cliInputAdapter = appConfig.getCliInputAdapter();
        cliInputAdapter.run();
    }
}
