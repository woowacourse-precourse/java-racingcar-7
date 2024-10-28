package racingcar.service;

import java.util.List;

public class ResultGeneratorService {


    public String generateRacingResult(String carName, int forwardCount){
        String forwardExpression = "-".repeat(forwardCount);
        return carName + " : " + forwardExpression;
    }


    public String generateWinnerResult(List<String> winnerList){
        return String.join(", ", winnerList);
    }


}
