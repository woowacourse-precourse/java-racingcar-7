package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.dto.UserDto;

import static racingcar.common.constant.InputViewConst.*;

public class InputView {

    public UserDto.Input getInput() {
        return UserDto.Input.of(getUserInputOfCar(), getUserInputOfCount());
    }

    private String getUserInputOfCar() {
        System.out.println(CAR_NAMES_REQUEST_PROMPT);
        return Console.readLine();
    }

    private String getUserInputOfCount() {
        System.out.println(COUNT_REQUEST_PROMPT);
        return Console.readLine();
    }
}
