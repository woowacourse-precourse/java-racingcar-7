package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Constant;

public class InputView {
    public void inputGameInfo() {
        System.out.println(Constant.INPUT_PLAYERS_PROMPT);
        String players = Console.readLine();
        System.out.println(Constant.INPUT_TRIAL_PROMPT);
        int trial = Integer.parseInt(Console.readLine());
    }
}
