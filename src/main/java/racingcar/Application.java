package racingcar;

import racingcar.car.service.CarNameService;
import racingcar.car.util.RandomNumberGenerator;
import racingcar.car.validation.CarNameValidator;
import racingcar.race.controller.RaceController;
import racingcar.race.service.RaceService;
import racingcar.race.validation.AttemptCountValidator;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {

        try {
            CarNameValidator carNameValidator = new CarNameValidator();
            RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
            CarNameService carNameService = new CarNameService();
            AttemptCountValidator attemptCountValidator = new AttemptCountValidator();

            Input input = new Input(carNameValidator, attemptCountValidator);
            Output output = new Output();

            RaceService raceService = new RaceService(carNameService, randomNumberGenerator, output);
            RaceController raceController = new RaceController(raceService, input, output);

            // 경주 시작
            raceController.startRace();
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
