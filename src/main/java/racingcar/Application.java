package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.car.Cars;
import racingcar.racing.RacingCarService;
import racingcar.racing.RacingCount;
import racingcar.view.InputReader;
import racingcar.view.ResultWriter;

public class Application {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        ResultWriter writer = new ResultWriter();

        final List<String> carNames = reader.readCarNames();
        Cars cars = new Cars(carNames);

        RacingCarService service = new RacingCarService(cars);
        final RacingCount racingCount = reader.readRacingCount();

        writer.writeResultStart();
        for (int i = 0; i < racingCount.getValue(); i++) {
            final Cars racedCars = service.race();
            writer.writeResult(racedCars);
        }

        final List<String> winners = service.findWinners();
        writer.writeWinners(winners);

        Console.close();
    }
}
