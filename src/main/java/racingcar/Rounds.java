package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Rounds {
    private final Integer roundSize;

    public Rounds(Integer roundSize) {
        this.roundSize = roundSize;
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
}
