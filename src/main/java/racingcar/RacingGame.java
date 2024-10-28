package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Map<String,Integer>> carInfoList;
    private Integer tryCount;

    public RacingGame(List<String> carNames, Integer tryCount) {
        this.carInfoList = convertCarListToInfoList(carNames);
        this.tryCount = tryCount;
    }

    public void printEachResult(){
        for (Map<String,Integer> carInfo : carInfoList){
            for (Map.Entry<String,Integer> entry : carInfo.entrySet()){
                System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
            }
            System.out.println();
        }
    }

    public void printFinalResult() {
        int maxDistance = findMaxDistance();
        List<String> winners = findWinnersByMaxDistance(maxDistance);
        System.out.println("최종 우승자 : "+String.join(", ", winners));
    }

    private int findMaxDistance() {
        return carInfoList.stream()
                .flatMap(carInfo -> carInfo.values().stream())
                .max(Integer::compareTo)
                .orElse(0);
    }

    private List<String> findWinnersByMaxDistance(int maxDistance) {
        return carInfoList.stream()
                .flatMap(carInfo -> carInfo.entrySet().stream())
                .filter(entry -> entry.getValue() == maxDistance)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
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
