package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> printStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String playerNamesInput = Console.readLine();
        List<String> playerNamesArray = Arrays.asList(playerNamesInput.split(","));

        return playerNamesArray;
    }

    public int printRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?\n");

        return Integer.parseInt(Console.readLine());
    }
}