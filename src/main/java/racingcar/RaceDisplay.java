package racingcar;

import java.util.HashMap;

import static racingcar.Constants.FINAL_RESULT;
import static racingcar.Constants.RACE_RUNNING_MESSAGE;
import static racingcar.RacingGameController.calculateWinner;

public class RaceDisplay {
    public static void displayRaceStatus(HashMap<String, String> carNameMap) {
        System.out.println();
        System.out.println(RACE_RUNNING_MESSAGE);
        for (HashMap.Entry<String, String> entry : carNameMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void displayRaceResult(HashMap<String, String> carNameMap) {
        StringBuilder raceResult = new StringBuilder();
        for (String carName : carNameMap.keySet()) {
            if (carNameMap.get(carName).equals(calculateWinner())) {
                raceResult.append(carName);
                raceResult.append(", ");
            }
        }
        raceResult.delete((raceResult.length() - 2), raceResult.length());
        System.out.println();
        System.out.print(FINAL_RESULT + raceResult);
    }
}
