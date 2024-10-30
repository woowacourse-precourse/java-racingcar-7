package racingcar;

import racingcar.config.RunnerConfig;

public class Application {
    public static void main(String[] args) {
        RunnerConfig.getInstance().run();
    }
}