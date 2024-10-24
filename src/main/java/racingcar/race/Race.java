package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    private List<Racer> racers;
    private int lap = 0;

    public Race(Racer[] racers) {
        this.racers = Arrays.asList(racers);
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
