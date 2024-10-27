package inspector;

import java.util.ArrayList;
import racingcar.OutputManager;
import racingcar.RacingCar;

public class InspectRaceResult {
    ArrayList<String> winner = new ArrayList<>();
    private int highestDistance = 0;

    public void inspectWinner(ArrayList<RacingCar> group){
        for(RacingCar racingCar : group){
            compareElementToHighestDistance(racingCar);
        }
        OutputManager.printRaceResult(winner);
    }

    public void compareElementToHighestDistance(RacingCar racingCar){
        if(racingCar.isNewWinner(highestDistance)){
            winner.clear();
            highestDistance = racingCar.getDistance();
        }
        /* 이전 값과 같은 경우 : 당연히 highestDistance와 같기에 아래 if문이 참이다
           새로운 값으로 갱신한 경우 : 위에서 변수 highestDistance가 갱신되어서 아래의 if문이 참이다.*/
        if(racingCar.isSameDistance(highestDistance)){
            addRacingCarToWinnerGroup(racingCar);
        }
    }

    private void addRacingCarToWinnerGroup(RacingCar racingCar){
        winner.add(racingCar.getCarName());
    }
}
