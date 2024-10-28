package racingcar;

import java.util.ArrayList;
import java.util.Map;

public class Model {
    private Map<String, ArrayList<Integer>> carMap;
    private String winner;

    public Model(Map<String, ArrayList<Integer>> carMap, String winner) {
        this.carMap = carMap;
        this.winner = winner;
    }

}
