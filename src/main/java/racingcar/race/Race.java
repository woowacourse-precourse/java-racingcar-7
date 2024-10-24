package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Racer> racers;
    private int lap = 0;
    private int bestRecord = 0;

    public Race() {
        racers = new ArrayList<>();
    }

    public Race(String[] racerNames) {
        this();
        for(String racerName : racerNames) {
            this.racers.add(new Racer(racerName));
        }
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

            if(racer.getPosition() > bestRecord) {
                bestRecord = racer.getPosition();
            }
        }
    }

    public List<Racer> getRacers() {
        return racers;
    }

    public List<Racer> getWinner(){
        List<Racer> winners = new ArrayList<>();

        for(Racer racer : racers) {
            if(racer.getPosition() == bestRecord) {
                winners.add(racer);
            }
        }

        return winners;
    }

}
