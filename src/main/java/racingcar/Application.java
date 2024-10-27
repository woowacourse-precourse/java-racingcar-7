package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;
import racingcar.repository.CarRepository;
import racingcar.repository.impl.CarRepositoryImpl;
import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.service.WinnerService;
import racingcar.validator.impl.NameValidator;
import racingcar.validator.impl.NumberValidator;
import racingcar.view.CarInputView;
import racingcar.view.RaceOutputView;
import racingcar.view.NumberInputView;
import racingcar.view.WinnersOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // Repository
        CarRepository carRepository = new CarRepositoryImpl();

        // Validator
        NameValidator nameValidator = new NameValidator();
        NumberValidator numberValidator = new NumberValidator();

        // View
        CarInputView carInputView = new CarInputView();
        RaceOutputView raceOutputView = new RaceOutputView();
        NumberInputView numberInputView = new NumberInputView();
        WinnersOutputView winnersOutputView = new WinnersOutputView();

        // Service
        CarService carService = new CarService(carRepository, nameValidator);
        RacingService racingService = new RacingService(carRepository, numberValidator, raceOutputView);
        WinnerService winnerService = new WinnerService(carRepository);

        // Controller
        RacingController racingController = new RacingController(
                carService,
                racingService,
                winnerService,
                carInputView,
                numberInputView,
                raceOutputView,
                winnersOutputView);

        // 실행
        racingController.run();

        Console.close();
    }
}
