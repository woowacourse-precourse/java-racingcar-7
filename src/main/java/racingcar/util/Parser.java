package racingcar.util;

import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public abstract class Parser {

    public static List<RacingCar> extractCarNames(String carNames) {
        StringTokenizer tokenizer = new StringTokenizer(carNames,",");
        List<RacingCar> cars = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            cars.add(new RacingCar(tokenizer.nextToken()));
        }
        return cars;
    }

    public static int parseNumber(String loopCount) {
        try {
            return Integer.parseInt(loopCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
