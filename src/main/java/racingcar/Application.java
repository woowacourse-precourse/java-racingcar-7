package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceController;
import racingcar.dto.RaceRound;
import racingcar.model.Name;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<Name> names = Name.createNames(input);

        RaceRound raceRound = RaceRound.inputRounds();

        RaceController raceController = new RaceController(names, raceRound.getRounds());
        raceController.startRace();
    }
}
