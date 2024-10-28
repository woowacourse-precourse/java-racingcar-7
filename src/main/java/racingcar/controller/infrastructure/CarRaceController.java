package racingcar.controller.infrastructure;

import racingcar.controller.domain.RaceController;
import racingcar.model.domain.Race;
import racingcar.model.infrastructure.CarRace;
import racingcar.model.infrastructure.RaceRule;
import racingcar.util.Splitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.enumerate.OutputConstant;

import java.util.List;

import static racingcar.view.enumerate.ErrorOutputConstant.NAME_LENGTH_OVER_5_ERROR;

public class CarRaceController implements RaceController {
    private final InputView inputView;
    private final OutputView outputView;

    public CarRaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void run() {
        Race race = createRacing();
        playRace(race);
        announce(race);
    }

    @Override
    // toNames(String) splitNames
    public List<String> process(String in) {
        List<String> split = Splitter.split(in);
        for (String s : split) {
            validateNameLength(s);
        }
        return split;
    }

    private void announce(Race race) {
        List<String> winners = race.findWinners();
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

    // createRace
    private Race createRacing() {
        String carNamesInput = requestCarNames();
        int tryTimes = requestTryTimes();
        List<String> carNames = process(carNamesInput);
        return CarRace.init(carNames, tryTimes, new RaceRule());
    }


    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER_5_ERROR.getSentence());
        }
    }
}
