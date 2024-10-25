package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private final List<String> inputs;

    public Parser(List<String> inputs) {
        this.inputs = inputs;
    }

    public List<String> parseCarNameInput() {
        String line = inputs.getFirst();
        List<String> carNames = Arrays.asList(line.split(","));

        return carNames.stream()
                .map(String::trim)
                .map(this::validateCarName)
                .collect(Collectors.toList());
    }

    public int parseRaceRoundInput() {
        String line = inputs.get(1);
        return parseRound(line);
    }

    private int parseRound(String secondLine) {
        try {
            int round = Integer.parseInt(secondLine);
            if(round <= 0) {
                throw new NumberFormatException();
            }
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자의 형식이 잘못되었습니다.");
        }
    }

    private String validateCarName(String carName) {
        if(carName.isEmpty() || carName.length() > Constants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("올바른 자동차 이름이 아닙니다.");
        }
        return carName;
    }
}
