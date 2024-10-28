package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model {
    private Map<String, ArrayList<Integer>> carMap;
    private List<String> winner;


    public Map<String, ArrayList<Integer>> getCarMap(){
        return carMap;
    }

    public List<String> getWinner(){
        return winner;
    }

    public Model(Map<String, ArrayList<Integer>> carMap, List<String> winner) {
        this.carMap = carMap;
        this.winner = winner;
    }

}
