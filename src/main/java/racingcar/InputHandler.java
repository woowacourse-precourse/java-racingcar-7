package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class InputHandler {
    Map<String, Integer> mapNameDist = new HashMap<String, Integer>();

    public Map<String, Integer> readCarNames() {
        String inputPrimitive = Console.readLine();

        if (inputPrimitive == null || inputPrimitive.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY.getMessage());
        }

        String[] carNames = inputPrimitive.split(",");

        for (String carName : carNames) {
            if (validateName(carName)) {
                mapNameDist.put(carName, 0);
            }
        }

        return mapNameDist;
    }

    public int readIterNum() {
        int numIter = 0;

        String inputPrimitive = Console.readLine();

        if (inputPrimitive == null || inputPrimitive.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY.getMessage());
        }

        for (char c : inputPrimitive.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException(ExceptionMessage.NUM_NOT_NUM.getMessage());
            }

            numIter *= 10;
            numIter += c - '0';
        }

        return numIter;
    }

    private boolean validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_EMPTY.getMessage());
        }

        if (mapNameDist.containsKey(name)) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_DUPLICATED.getMessage());
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_TOO_LONG.getMessage());
        }

        return true;
    }
}
