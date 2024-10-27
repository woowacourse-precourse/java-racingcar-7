package racingcar.controller.infrastructure;

import racingcar.controller.domain.GameController;
import racingcar.model.domain.Race;
import racingcar.model.domain.RaceFind;
import racingcar.model.infrastructure.CarRace;
import racingcar.model.infrastructure.RaceRule;
import racingcar.util.Splitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.enumerate.OutputConstant;

import java.util.List;

public class RaceController implements GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void run() {
        RaceFind race = createRacing();
        playRace(race);
        announce(race);
    }

    @Override
    public List<String> process(String in) {
        List<String> split = Splitter.split(in);
        for (String s : split) {
            validateNameLength(s);
        }
        return split;
    }

    private void announce(RaceFind race) {
        List<String> winners = race.getWinners();
        outputView.printWinners(winners);
    }

    private void playRace(Race race) {
        race.runFullRace(outputView);
    }

    private int requestTryTimes() {
        outputView.print(OutputConstant.PRINT_INPUT_TRY_TIMES_SENTENCE);
        return inputView.inputRaceTryTimes();
    }

    private String requestCarNames() {
        outputView.print(OutputConstant.PRINT_INPUT_CAR_NAMES_SENTENCE);
        return inputView.inputCarName();
    }

    private RaceFind createRacing() {
        String carNamesInput = requestCarNames();
        int tryTimes = requestTryTimes();
        List<String> carNames = process(carNamesInput);
        return CarRace.init(carNames, tryTimes,new RaceRule());
    }


    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5글자이하의 자동차의 이름을 입력해주세요.");
        }
    }
}
