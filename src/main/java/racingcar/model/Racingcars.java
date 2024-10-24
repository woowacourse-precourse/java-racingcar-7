package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Racingcars {
    private final List<Racingcar> racingcarList;

    public Racingcars() {
        this.racingcarList = new ArrayList<>();
    }

    public void addCar(Racingcar racingcar) {
        racingcarList.add(racingcar);
    }

    public List<Racingcar> getRacingcarList(){
        return racingcarList;
    }
}
