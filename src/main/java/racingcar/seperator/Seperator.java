package racingcar.seperator;

import java.util.ArrayList;

public class Seperator {
    private final String[] names;

    public String[] getNames() {
        return names;
    }

    public Seperator(String s) {
        names=s.split(",");
    }

}
