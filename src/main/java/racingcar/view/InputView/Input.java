package racingcar.view.InputView;

import racingcar.model.Error.CarNameValidator;
import racingcar.model.Error.RaceCountValidator;

import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private CarNameValidator carNameValidator;
    private RaceCountValidator raceNumValidator;

    public Input(CarNameValidator carNameValidator, RaceCountValidator raceNumValidator) {
        this.carNameValidator = carNameValidator;
        this.raceNumValidator = raceNumValidator;
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = readLine();
        return carNameValidator.validateCarName(inputCarName);
    }

    public int inputRaceNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String raceNum = readLine();
        return raceNumValidator.validateRaceNum(raceNum);
    }
}
