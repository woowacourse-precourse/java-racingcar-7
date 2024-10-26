package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.view.InputView;

public class GameController {
    private Validator validator = new Validator();

    public List<String> getCarNames(){
        InputView.carNamesMessage();
        String carNames = Console.readLine();
        return validator.validateCarName(carNames);
    }



}
