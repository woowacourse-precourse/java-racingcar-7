package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        appConfig.run();
        Console.close();
    }
}