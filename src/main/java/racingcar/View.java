package racingcar;

import static racingcar.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    public String readInput() {
        return Console.readLine();
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printCarNamePrompt() {
        System.out.println(PROMPT_CAR_NAME);
    }

    public void printAttemptsPrompt() {
        System.out.println(PROMPT_ATTEMPTS);
    }

    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void print(List<Car> roundResult) {
        roundResult.forEach(car ->
                System.out.printf("%s : %s%n", car.getName(), car.getMoving())
        );
    }

    public void printFinalResult(List<String> winners) {
        System.out.print(FINAL_WINNERS_MESSAGE + String.join(", ", winners));
    }
}
