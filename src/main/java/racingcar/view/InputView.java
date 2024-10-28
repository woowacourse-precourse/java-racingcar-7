package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.util.CarValidator;
import racingcar.util.Parser;
import racingcar.util.RaceValidator;

public class InputView {

    private final CarValidator carValidator;
    private final RaceValidator raceValidator;
    private final Parser parser;

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public InputView(CarValidator carValidator, RaceValidator raceValidator, Parser parser) {
        this.carValidator = carValidator;
        this.raceValidator = raceValidator;
        this.parser = parser;
    }

    private String readLine() {
        return Console.readLine();
    }

    public List<String> getCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String input = readLine();
        ArrayList<String> carNames = parser.stringToList(input);
        carValidator.checkCarNames(carNames);
        carValidator.checkCarCount(carNames);
        return carNames;
    }

    public int getRaceCount() {
        System.out.println(RACE_COUNT_INPUT_MESSAGE);
        String input = readLine();
        int raceCount = parser.stringToInt(input);
        raceValidator.checkRaceCount(raceCount);
        return raceCount;
    }
}
