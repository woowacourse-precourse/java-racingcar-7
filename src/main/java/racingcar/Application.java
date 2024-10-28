package racingcar;

import racingcar.executor.CarRacingDependencyInjector;
import racingcar.executor.CarRacingExecutor;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarRacingDependencyInjector injector = new CarRacingDependencyInjector();
        CarRacingExecutor executor = injector.createCarRacingExecutor();
        executor.run();
    }
}
