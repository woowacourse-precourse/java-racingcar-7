package racingcar;

import static racingcar.Parser.parseAttempts;
import static racingcar.Parser.parseCarNames;

import java.util.HashMap;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        ConsoleIO consoleIO = new ConsoleIO();

        HashMap<String, String> inputData = consoleIO.input();
        CarRacing carRacing = new CarRacing(parseCarNames(inputData.get("carNames")),
                parseAttempts(inputData.get("attempts")));
        List<String> outputData = carRacing.race();
        consoleIO.output(outputData);
    }
}
