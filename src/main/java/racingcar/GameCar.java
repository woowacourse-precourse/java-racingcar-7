package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameCar {
    private String carName;
    private List<String> forwardMarks;

    public GameCar(String carName) {
        this.carName = carName;
        this.forwardMarks = new ArrayList<>(List.of(carName + " : "));
    }

    void move(int randNumber) {
        if (randNumCheck(randNumber)) {
            forwardMarks.add("-");
        }
    }

    void displayPrint() {
        String joinString = String.join("", forwardMarks);
        System.out.println(joinString);
    }

    private boolean randNumCheck(int randNumber) {
        if (randNumber < 4) {
            return false;
        }
        return true;
    }

    public int getForwardMarksSize() {
        return forwardMarks.size();
    }

    public String getCarName() {
        return carName;
    }
}
