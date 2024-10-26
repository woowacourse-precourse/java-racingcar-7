package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private List<RacingCar> carList = new ArrayList<>();
    private int roundNum;

    public RacingCarGame(List<String> carNames, int roundNum){
        carList.addAll(carNames.stream()
                .map(RacingCar::new)
                .toList());
        this.roundNum = roundNum;
    }

    public void start(){
        for (int i = 0; i < roundNum; i++) {
            round();
        }
    }

    public void round(){
        carList.forEach(RacingCar::moveForward);
        carList.forEach(c -> System.out.println(c.getName() + " : " + String.valueOf("-").repeat(c.getMoveCount())));
        System.out.println();
    }

    public List<String> selectWinners(){
        int maxMoveCount = 0;

        for(RacingCar car: carList){
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        List<String> winners = new ArrayList<>();
        for (RacingCar car: carList){
            if(car.getMoveCount() == maxMoveCount){
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
