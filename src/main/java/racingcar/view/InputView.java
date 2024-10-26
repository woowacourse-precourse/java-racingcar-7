package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.operator.Game;
import racingcar.user.SettingGameUser;

public class InputView {
    public static int trynum;
    public static String[] result;

    public InputView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        trynum = Integer.parseInt(Console.readLine());
        result = input.split(",");
        SettingGameUser settingGameUser = new SettingGameUser(result);
        Game game = new Game();
        game.GameProgress();

    }
}
