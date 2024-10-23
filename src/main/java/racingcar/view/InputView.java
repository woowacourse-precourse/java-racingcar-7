package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.PlayerValidation;

public class InputView {

    public String readPlayers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String players = Console.readLine();
        PlayerValidation.validation(players);
        return players;
    }

    public String readCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
