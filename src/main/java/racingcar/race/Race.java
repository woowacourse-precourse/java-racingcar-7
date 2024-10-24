package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.ui.UI;

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
        System.out.println("실행결과");

        while(lap < times) {
            run();
            progress();
            lap++;
        }

        UI.showResult(getWinner().toArray(Racer[]::new));
    }

    public void run(){
        for (Racer racer : racers) {
            racer.move(Randoms.pickNumberInRange(0,9));

            if(racer.getPosition() > bestRecord) {
                bestRecord = racer.getPosition();
            }
        }
    }

    public void progress(){
        for(Racer racer : racers) {
            UI.showProgress(racer);
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
