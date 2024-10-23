package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarRunner {

    private List<RacingCar> carList = new ArrayList<>();
    private int n;

    public RacingCarRunner(String[] cars, int n) {
        Arrays.stream(cars).forEach(carName -> this.carList.add(new RacingCar(carName)));
        this.n = n;
    }

    public void run() {
        while (n > 0) {
            carList.stream().forEach(car -> {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random >= 4) {
                    car.moveForward();
                }
            });
            this.n--;
        }
    }
}
