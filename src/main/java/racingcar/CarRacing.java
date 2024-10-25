package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.accelerator.BrokenAccelerator;

public class CarRacing {

    private int attempts;
    private final CarGroup carGroup;

    CarRacing(CarGroup carGroup, int attempts) {
        this.carGroup = carGroup;
        this.attempts = attempts;
    }

    public int getAttempts() {
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
