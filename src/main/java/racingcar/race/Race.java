package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.ui.UI;

public class Race {
    private List<Racer> racers;
    private int lap;
    private int bestRecord;

    public Race() {
        racers = new ArrayList<>();
        reset();
    }

    public Race(String[] racerNames) {
        this();

        if(racerNames.length == 0) {
            throw new IllegalArgumentException("비어있는 레이서 목록입니다.");
        }

        for(String racerName : racerNames) {
            if(racerName == null || racerName.isEmpty()) {
                throw new IllegalArgumentException("레이서 이름이 필요합니다.");
            }
            this.racers.add(new Racer(racerName));
        }
    }

    public void startRace(int times){
        if(racers.isEmpty()){
            throw new IllegalArgumentException("선수가 없어 레이스를 진행할 수 없습니다.");
        }

        reset();
        
        if(times<=0){
            throw new IllegalArgumentException(times + "만큼 진행할 수 없습니다.");
        }

        System.out.println("실행결과");

        while(lap < times) {
            run();
            UI.showProgress(racers);
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

    private void reset(){
        lap = 0;
        bestRecord = 0;
    }

}
