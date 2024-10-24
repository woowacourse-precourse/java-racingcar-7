package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private Racer[] racers;
    private int lap = 0;

    public Race(Racer[] racers) {
        this.racers = racers;
    }

    public void startRace(int times){
        while(lap < times) {
            run();
            lap++;
        }
    }

    public void run(){
        for (Racer racer : racers) {
            racer.move(Randoms.pickNumberInRange(0,9));
        }
    }
}
