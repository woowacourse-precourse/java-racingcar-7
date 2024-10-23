package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarRunner {

    private List<RacingCar> carList = new ArrayList<>();
    private final int n;

    public RacingCarRunner(String[] cars, int n) {
        Arrays.stream(cars).forEach(carName -> this.carList.add(new RacingCar(carName)));
        this.n = n;
    }

    public void run() {
        System.out.println(carList);
    }
}
