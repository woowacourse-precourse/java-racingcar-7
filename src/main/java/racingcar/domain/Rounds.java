package racingcar.domain;

import static racingcar.message.ExceptionMessage.INVALID_RANGE_ROUND_SIZE;
import static racingcar.message.ExceptionMessage.INVALID_TYPE_ROUND_SIZE;

import java.util.ArrayList;
import java.util.List;
import racingcar.handler.OutputHandler;
import racingcar.util.RandomUtil;

public class Rounds {
    static final int MIN_ROUND_COUNT = 1;
    static final int MAX_ROUND_COUNT = 20;

    private final Integer roundSize;

    public Rounds(String roundSizeInput) {
        Integer roundSize = validateType(roundSizeInput);
        this.roundSize = validateSize(roundSize);
    }

    public void proceedRounds(List<Car> cars, OutputHandler outputHandler) {
        for (int i = 0; i < roundSize; i++) {
            List<String> roundResult = processRound(cars);
            outputHandler.printRoundResult(roundResult);
        }
    }

    private List<String> processRound(List<Car> cars) {
        List<String> result = new ArrayList<>();

        for (Car car : cars) {
            int power = RandomUtil.getRandomNumber();
            car.move(power);

            result.add(car.getInfo());
        }

        return result;
    }

    private Integer validateType(String input) {
        Integer roundSize;
        try {
            roundSize = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(INVALID_TYPE_ROUND_SIZE.getMessage()));
        }

        return roundSize;
    }

    private Integer validateSize(Integer roundSize) {
        if (roundSize == null || roundSize < MIN_ROUND_COUNT || roundSize > MAX_ROUND_COUNT) {
            throw new IllegalArgumentException(
                    String.format(INVALID_RANGE_ROUND_SIZE.getMessage(), MIN_ROUND_COUNT, MAX_ROUND_COUNT));
        }

        return roundSize;
    }
}
