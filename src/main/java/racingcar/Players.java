package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<String> names = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();

    public void addPlayers(List<String> names){
        this.names.addAll(names);
        for (int i = 0; i < names.size(); i++) {
            count.add(0);
        }
    }

}
