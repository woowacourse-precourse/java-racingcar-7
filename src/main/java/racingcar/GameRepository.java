package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    private List<String> names = new ArrayList<>();
    private int round;

    public void setCarName(List<String> splitNames) {
        this.names = splitNames;
    }

    public String getCarName(int index) {
        return this.names.get(index);
    }

    public List<String> getAllNames() {
        return this.names;
    }

    public void setRound(int input) {
        this.round = input;
    }

    public int getRound() {
        return this.round;
    }
}
