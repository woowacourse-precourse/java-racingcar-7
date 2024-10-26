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

    public void round(){
        carList.forEach(RacingCar::moveForward);
        carList.forEach(c -> System.out.println(c.getName() + ": " + c.getMoveCount()));
        System.out.println();
    }
}
