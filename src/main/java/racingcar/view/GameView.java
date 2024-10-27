package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import racingcar.domain.Message;

public class GameView {


    public String getInputCarNames() {
        System.out.println(Message.promptInputCarNames());
        String carNamesInput = Console.readLine();
        return carNamesInput.trim();
    }

    public String getInputTryCount() {
        System.out.println(Message.promptInputTryCount());
        String tryCountInput = Console.readLine();
        System.out.println();
        return tryCountInput;
    }

    public void displayCarPosition(Map<String, String> updatedCarNameAndPosition) {
        for (Map.Entry<String, String> entry : updatedCarNameAndPosition.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void displayWinner(String winner) {
        System.out.println(winner);;
    }

}
