package racingcar.game.winner;

import java.util.List;

public class Winner {
    private final List<String> names;

    protected Winner(List<String> names) {
        this.names = names;
    }


    public List<String> getNames() {
        return List.copyOf(names);
    }
}
