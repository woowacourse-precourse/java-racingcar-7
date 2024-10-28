package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    private List<String> names = new ArrayList<>();
    private final List<String> winner = new ArrayList<>();
    private int round;

    public void setCarName(List<String> splitNames) {
        this.names = splitNames;
    }

    public List<String> getCarNames() {
        return this.names;
    }

    public void setRound(int input) {
        this.round = input;
    }

    public int getRound() {
        return this.round;
    }

    public void setWinner(String input) {
        this.winner.add(input);
    }

    public List<String> getWinner() {
        return this.winner;
    }

}
