package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;

public class Game {
    public int num; //시행 횟수

    public void start() {
        try {
            String[] cars = carInput();
            carInit(cars);
            gameProgress();
            winner();
        } catch(IllegalArgumentException e) {
            Output.error();
            throw new IllegalArgumentException();
        }
    }

    public String[] carInput() {
        Output.carName();
        String[] cars = Input.carName();
        Output.tryNum();
        num = Input.tryNum();

        return cars;
    }

    public void carInit(String[] cars) {

    }

    public void gameProgress() {

    }

    public void winner() {

    }
}
