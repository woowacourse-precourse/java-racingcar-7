package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarService {

    public static Map<String, Integer> raceAllRound(List<String> carNameList, int roundCount){
        Map<String, Integer> carMap = initCarList(carNameList, roundCount);

        for(int i=0; i<roundCount; i++) {
            carMap = raceOneRound(carMap);
            System.out.println();
        }
        return carMap;
    }

    public static Map<String, Integer> initCarList(List<String> carNameList, int roundCount){
        Map<String, Integer> carMap = new HashMap<>();

        for(final String carName: carNameList){
            carMap.put(carName, 0);
        }
        return carMap;
    }

    public static Map<String, Integer> raceOneRound(Map<String, Integer> carMap) {
        for (String carName : carMap.keySet()) {
            if (isMove()){
                carMap.put(carName, carMap.get(carName) + 1);
                printOneRaceResult(carName, carMap.get(carName));
            }
        }
        return carMap;
    }

    public static boolean isMove(){
        int randomMove = Randoms.pickNumberInRange(0, 9);
        if (randomMove >= 4) {
            return true;
        }
        else{
            return false;
        }
    }

    public static List<String> getWinnerList(Map<String, Integer> carList){
        int winValue = Collections.max(carList.values());
        List<String> findWinner = carList.entrySet().stream()
                .filter(e -> e.getValue() == winValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return findWinner;
    }

    public static void printOneRaceResult(String carName, int n){
        System.out.println(carName + " : " + "-".repeat(n));
    }
}
