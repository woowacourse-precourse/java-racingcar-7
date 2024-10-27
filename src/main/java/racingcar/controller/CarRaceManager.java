package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.UserInputDto;
import racingcar.model.Car;
import racingcar.util.UserInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceManager {

    private InputView inputView = new InputView();
    private UserInputValidator userInputValidator = new UserInputValidator();
    private CarRace carRace;

    public void start(){
        String[] userInitialInputs = inputView.getUserInitialInputs();
        UserInputDto userInputDto = userInputValidator.validate(userInitialInputs);

        initializeCars(userInputDto.carNames());
        List<String> winners = carRace.start(userInputDto.trialCount());

    }

    private void initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        carRace = new CarRace(cars);
    }
}
