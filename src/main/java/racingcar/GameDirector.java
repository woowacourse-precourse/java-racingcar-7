package racingcar;

import java.util.List;

public class GameDirector {

    private final String count;
    private final CarManager manager = new CarManager();

    public GameDirector(String carNames,String count) {
        manager.add(carNames);
        this.count = count;
    }

    public void run(String carNames, String count) {

    }
}
