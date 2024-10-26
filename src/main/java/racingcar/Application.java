package racingcar;

import java.util.List;
import racingcar.car.Cars;
import racingcar.car.RacingCarService;
import racingcar.view.InputReader;
import racingcar.view.ResultWriter;

public class Application {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        ResultWriter writer = new ResultWriter();

        final List<String> carNames = reader.readCarNames();
        final int tryCount = reader.readTryCount();

        Cars cars = new Cars(carNames);
        RacingCarService service = new RacingCarService(cars);

        writer.writeResultStart();
        for (int i = 0; i < tryCount; i++) {
            final Cars racedCars = service.race();
            writer.writeResult(racedCars);
        }

        final List<String> winners = service.findWinners();
        writer.writeWinners(winners);
    }
}
