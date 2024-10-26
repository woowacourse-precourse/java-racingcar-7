package racingcar;

import InputOutput.Input;
import InputOutput.Output;
import race.Race;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Output.firstPrintMessage();
        Map<String, String> race;
        race = Race.insertEnteredCarNamesIntoMap();
        Output.roundPrint();
        int count = Input.numberOfRounds();
        Output.raceResult(count, race);
    }
}
