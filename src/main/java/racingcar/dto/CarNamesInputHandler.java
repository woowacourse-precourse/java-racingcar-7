package racingcar.dto;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.Message;
import racingcar.validator.CarNamesValidator;

import java.util.List;

public class CarNamesInputHandler {
    String userResponse;
    public String getUserResponse() {
        System.out.print(Message.CAR_NAMES_REQUEST_MESSAGE);
        this.userResponse = Console.readLine();
        return userResponse;
    }
    public List<String> validateUserResponse() {
        // Separate the car names by separator
        if (this.userResponse.isEmpty()) {
            // At least one car is expected
            throw new IllegalArgumentException();
        }
        List<String> carNames = CarNamesValidator.isCarNamesValid(userResponse);
        return carNames;
    }
}
