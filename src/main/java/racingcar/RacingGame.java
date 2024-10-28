package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private List<Map<String,Integer>> carInfoList;
    private Integer tryCount;

    public RacingGame(List<String> carNames, Integer tryCount) {
        this.carInfoList = convertCarListToInfoList(carNames);
        this.tryCount = tryCount;
    }

    private List<Map<String,Integer>> convertCarListToInfoList(List<String> carNames){
        return carNames.stream().map(carName -> Map.of(carName, 0)).toList();
    }

    public int pickRandomCar(){
        return Randoms.pickNumberInRange(0, carInfoList.size()-1);
    }

    private boolean isMovingAvailable(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public List<Map<String,Integer>> getCarInfoList(){
        return carInfoList;
    }

    public Integer getTryCount(){
        return tryCount;
    }
}
