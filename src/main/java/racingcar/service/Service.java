package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;
import java.util.Map;
import racingcar.domain.RacingGame;

public class Service {
    private final Integer INITIAL_NUMBER = 0;
    private final Integer RANDOM_NUMBER_END = 9;
    private final Integer RANDOM_NUMBER_REQUIRED = 4;
    private RacingGame racingGame;

    public void setCarName(List<String> nameList){
        racingGame = new RacingGame(nameList);
    }

    public Map<String, String> playGame(){
        for(String name : racingGame.getKeys()){
            setRandomMovement(name);
        }

        return racingGame.getCarData();
    }

    public List<String> getWinner(){
        return racingGame.getGameWinner();
    }

    private void setRandomMovement(String name) {
        Integer num = pickNumberInRange(INITIAL_NUMBER,RANDOM_NUMBER_END);

        if(num>=RANDOM_NUMBER_REQUIRED){
            racingGame.setMovement(name);
        }
    }

}
