package racingcar;

import racingcar.adapter.inbound.InboundAdapter;
import racingcar.infrastructure.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        InboundAdapter cliInputAdapter = appConfig.getInboundAdapter();
        cliInputAdapter.run();
    }
}
