package racingcar;

import racingcar.domain.Game;
import racingcar.domain.InputFormValidator;
import racingcar.domain.Race;
import racingcar.domain.RacingHistory;
import racingcar.view.InputForm;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputForm inputForm = InputView.input();
        InputFormValidator.validate(inputForm);
        Race race = Race.create(inputForm);
        List<RacingHistory> histories = Game.play(race);
        OutputView.print(histories, race);
    }
}
