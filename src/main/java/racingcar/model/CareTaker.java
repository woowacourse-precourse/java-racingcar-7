package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<GameMemento> gameMementoList;


    public CareTaker() {
        this.gameMementoList = new ArrayList<GameMemento>();
    }

    public void add(GameMemento state) {
        gameMementoList.add(state);
    }

    public GameMemento get(int index) {
        return gameMementoList.get(index);
    }

    public List<GameMemento> getAllMemento() {
        return gameMementoList;
    }
}
