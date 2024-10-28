package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.model.*;

public class Game {
    public int num;
    public CarHandler cars;

    public void start() {
        try {
            String[] names = carInput();
            carInit(names);
            gameProgress();
            winner();
        } catch(IllegalArgumentException e) {
            Output.error();
            throw new IllegalArgumentException();
        }
    }

    public String[] carInput() throws IllegalArgumentException {
        Output.carName();
        String[] names = Input.carName();
        Output.tryNum();
        num = Input.tryNum();

        return names;
    }

    public void carInit(String[] names) throws IllegalArgumentException {
        cars = new CarHandler();
        for(String name : names) {
            if(name.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.addCar(name);
        }
    }

    public void gameProgress() {
        Output.result();
        for(int i=0; i<num; i++) {
            cars.goCar();
            cars.printPos();
            System.out.println();
        }
    }

    public void winner() {
        Output.winner(cars.checkWinner());
    }
}
