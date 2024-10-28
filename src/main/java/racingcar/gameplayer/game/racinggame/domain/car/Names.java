package racingcar.gameplayer.game.racinggame.domain.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Names {

    private final List<Name> names = new ArrayList<>();


    public Names(String[] names) {
        this.names.addAll(Arrays.stream(names).map(Name::new).toList());
    }

    public Names(String names) {
        this(names.split(","));
    }

    public List<Name> getNames() {
        return names;
    }
}
