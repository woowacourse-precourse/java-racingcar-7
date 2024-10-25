package racingcar.dto;

import java.util.List;

public class Winners {
    private List<String> names;

    public Winners(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }
}
