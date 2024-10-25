package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    public String name;
    public int position;
    public List<Integer> randomNumbers;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
        this.randomNumbers = new ArrayList<>();
    }
}
