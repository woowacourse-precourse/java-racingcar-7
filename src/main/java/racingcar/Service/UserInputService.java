package racingcar.Service;

import racingcar.Utils.InputValidator;

public class UserInputService {
    public static void racingCarUserInput(String[] carNames){
        for (String carName : carNames) {
            InputValidator.carNameMoreThan5TextException(carName);
            InputValidator.carNameTextAndNumberOtherThanException(carName);
            InputValidator.validateNotNullOrEmpty(carName);
        }
        InputValidator.isAtLeastTwoCars(carNames);
    }
}
