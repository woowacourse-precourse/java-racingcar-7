package racingcar;

import racingcar.config.RacingcarConfig;
import racingcar.controller.CarController;
import racingcar.domain.CarNameCollect;
import racingcar.domain.TryCount;
import racingcar.viewer.Viewer;

public class Application {

    public static void main(String[] args) {
        Viewer viewer = RacingcarConfig.viewer();
        CarController carController = RacingcarConfig.carController();

        try {
            CarNameCollect carNameCollect = carController.toCarNameCollect();
            TryCount tryCount = carController.toTryCount();

            carController.startRace(carNameCollect, tryCount);

            viewer.print();
        } catch (OutOfMemoryError | Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
