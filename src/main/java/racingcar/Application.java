package racingcar;

import racingcar.domain.Race;
import racingcar.view.InputUtil;
import racingcar.view.OutputUtil;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> names = InputUtil.inputNames();
        int round = Integer.parseInt(InputUtil.inputNumber());
        Race race = new Race(new NumberGenerator(), names);
        race.run(round);
        OutputUtil.printResult(race.getWinners());
    }
}
