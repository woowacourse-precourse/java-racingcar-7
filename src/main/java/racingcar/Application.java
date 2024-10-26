package racingcar;

import racingcar.config.AppConfig;
import racingcar.config.RaceConfig;
import racingcar.domain.CarFactory;
import racingcar.domain.CarRegistry;
import racingcar.domain.RaceResult;
import racingcar.domain.Stadium;
import racingcar.io.Input;
import racingcar.io.View;


public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();

        Input input = appConfig.createInput();
        View view = appConfig.createView();

        view.printCarNamesGuide();
        String carNames = input.carNames();

        view.printRoundsGuide();
        Integer rounds = Integer.parseInt(input.rounds());
        input.closeConsole();

        Application application = new Application(carNames);
        application.run(view, rounds);
    }
}
