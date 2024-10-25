package racingcar;

import racingcar.car.service.CarNameService;
import racingcar.car.service.CarStatusService;
import racingcar.car.util.RandomNumberGenerator;
import racingcar.car.validation.CarNameValidator;
import racingcar.race.controller.RaceController;
import racingcar.race.service.RaceService;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // View 클래스 (입력/출력 담당)
        Input input = new Input();
        Output output = new Output();

        // Car 관련 서비스 및 Validator
        CarNameValidator carNameValidator = new CarNameValidator();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        CarNameService carNameService = new CarNameService(carNameValidator);
        CarStatusService carStatusService = new CarStatusService(randomNumberGenerator, output);

        // RaceService 생성
        RaceService raceService = new RaceService(carNameService, carStatusService, input, output);

        // RaceController 생성 및 경주 시작
        RaceController raceController = new RaceController(raceService, input, output);
        raceController.startRace();
    }
}
