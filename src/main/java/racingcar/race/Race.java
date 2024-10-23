package racingcar.race;

import racingcar.Racer;

public class Race {
    private Racer[] racers;
    private int lap = 0;

    public Race(Racer[] racers) {
        this.racers = racers;
    }

    public void run(){
        lap++;

        for (Racer racer : racers) {
            racer.move();
        }
    }
}
