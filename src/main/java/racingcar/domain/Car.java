package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public Car(String name) {
        this.name = name;
    }

    private int id;

    private String name;

    private List<Integer> roundIdList = new ArrayList<>();

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getRoundIdList() {
        return this.roundIdList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addRound(Round round) {
        if (!roundIdList.contains(round.getId())) {
            this.roundIdList.add(round.getId());
        }
    }
}
