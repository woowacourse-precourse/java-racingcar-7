package racingcar.strategy;

import java.util.Random;

public class MoveStrategy implements  Strategy{

    private final static Random random = new Random();

    @Override
    public int random() {
        return random.nextInt();
    }

}
