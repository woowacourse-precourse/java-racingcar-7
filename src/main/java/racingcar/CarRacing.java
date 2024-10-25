package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.accelerator.BrokenAccelerator;

public class CarRacing {

    private int attempts;
    private final CarGroup carGroup;

    CarRacing(String carNamesInput, String attemptsInput) {
        this.carGroup = new CarGroup(parseCarList(carNamesInput));
        this.attempts = parseAttempts(attemptsInput);
    }

    public int getAttempts() {
        return attempts;
    }

    public static List<Car> parseCarList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int parseAttempts(String input) {
        int attempts = 0;
        try {
            attempts = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (attempts < 0) {
            throw new IllegalArgumentException();
        }
        return attempts;
    }

    public List<String> race() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < attempts; i++) {
            carGroup.accelerateAll(new BrokenAccelerator());
            data.add(carGroup.toString());
        }
        CarRacingWinner winner = new CarRacingWinner(carGroup);
        data.add(winner.toString());

        return data;
    }
}
