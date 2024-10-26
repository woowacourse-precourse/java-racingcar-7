package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    private List<String> winners = new ArrayList<>();

    public List<Boolean> carGoList(List<String> carList){
        int carCount = carList.size();
        List<Boolean> result = new ArrayList<>();
        for(String car : carList){
            int randomNum = Randoms.pickNumberInRange(0,9);
            result.add(isGo(randomNum));
        }
        return result;
    }

    boolean isGo(int randomNum){
        return randomNum >= 4;
    }

    public List<String> winnerCarList(List<String> carList, List<Integer> distance){
        int bestScore = 0;
        int carIdx = 0;
        for(int i=0; i<distance.size(); i++){
            if(distance.get(i) >= bestScore){
                carIdx = i;
                bestScore = distance.get(i);
            }
        }
        winners.add(carList.get(carIdx));

        for(int i=0; i<distance.size(); i++){
            if((distance.get(i) == bestScore) && (i != carIdx)){
                winners.add(carList.get(i));
            }
        }
        return winners;
    }
}
