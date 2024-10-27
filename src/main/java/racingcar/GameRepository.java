package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    private List<String> names = new ArrayList<>();

    public void setCarName(List<String> splitNames) {
        this.names = splitNames;
    }

    public String getCarName(int index) {
        return this.names.get(index);
    }

    public List<String> getAllNames() {
        return this.names;
    }
}
