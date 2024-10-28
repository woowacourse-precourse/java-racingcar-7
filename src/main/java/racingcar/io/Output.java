package racingcar.io;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.message.Message;

public class Output {

    public void printResult(HashMap<String, Integer> result) {

        for (Map.Entry<String, Integer> car : result.entrySet()) {
            System.out.print(car.getKey() + " : ");
            printCarResult(car.getValue());
            System.out.println();
        }
        System.out.println();
    }

    private void printCarResult(Integer value) {

        for (int i = 0; i < value; i++) {
            System.out.print("-");
        }
    }

    public void printWinner(List<String> winners) {

        System.out.print(Message.OUTPUT_WINNER.getMessage());

        for (String winner : winners) {
            System.out.print(winner);
        }
    }
}
