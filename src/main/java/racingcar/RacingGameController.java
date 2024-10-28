package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

import static racingcar.Constants.*;
import static racingcar.RaceDisplay.displayRaceStatus;
import static racingcar.RaceDisplay.displayRaceResult;

public class RacingGameController {
    static HashMap<String, String> carNameMap = new HashMap<>();

    public static String inputCarNames() {
        System.out.println(CAR_NAME_INPUT_PROMPT);
        return Console.readLine();
    }

    public static int inputAttemptCount() {
        System.out.println(ATTEMPT_COUNT_INPUT_PROMPT);
        int inputNumber = Integer.parseInt(Console.readLine());
        if (inputNumber < 1) {
            throw new IllegalArgumentException();
        }
        return inputNumber;
    }

    public void splitCarNames(final String car) {
        if (car.contains(",,") || car.isEmpty() || car.endsWith(COMMA)) {
            throw new IllegalArgumentException();
        }
        String[] names = car.split(COMMA);
        for (String name : names) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException();
            }
            carNameMap.put(name, "");
        }
    }

    public String decideMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return FORWARD_MOTION;
        }
        return "";
    }

    public void runRacingGame() {
        splitCarNames(inputCarNames());
        int attemptCount = inputAttemptCount();
        for (int i = 0; i < attemptCount; i++) {
            determineCarForwardMovement();
            displayRaceStatus(carNameMap);
        }
        displayRaceResult(carNameMap);
    }

    public void determineCarForwardMovement() {
        for (String carName : carNameMap.keySet()) {
            carNameMap.replace(carName, carNameMap.get(carName) + decideMoveForward());
        }
    }

    public static String calculateWinner() {
        int maxNumber = 0;
        StringBuilder maxLength = new StringBuilder();
        for (String value : carNameMap.values()) {
            maxNumber = Math.max(maxNumber, value.length());
        }
        maxLength.append(FORWARD_MOTION.repeat(maxNumber));
        return maxLength.toString();
    }
}
