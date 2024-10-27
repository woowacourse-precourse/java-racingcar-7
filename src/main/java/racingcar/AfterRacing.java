package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AfterRacing {

    public static final Map<String, Integer> moveCountMap = new HashMap<>();

    public static String getRaceResult(Map<Integer, List<CarDto>> mapCar){
        Map<String, StringBuilder> preResult = new HashMap<>();
        StringBuilder moveResultsString = new StringBuilder();
        for(int i = 1; i <= mapCar.size(); i++ ){
            List<CarDto> carDtoList = mapCar.get(i);
            String moveResults = moveResults(carDtoList, preResult);
            moveResultsString.append(moveResults);
        }
        return moveResultsString.toString();
    }

    public static String moveResults(List<CarDto> carDtoList, Map<String, StringBuilder> preResult){
        StringBuilder tryResult = new StringBuilder();

        for (CarDto carDto : carDtoList) {
            makeResultString(carDto.getCarName(), carDto.isMoving(), preResult);
        }

        for (StringBuilder result : preResult.values()) {
            tryResult.append(result.toString()).append(System.lineSeparator());
        }

        tryResult.append(System.lineSeparator());

        return tryResult.toString();
    }

    public static void makeResultString(String carName, boolean isMoving, Map<String, StringBuilder> preResult){
        preResult.putIfAbsent(carName, new StringBuilder().append(carName).append(" : "));
        StringBuilder stringBuilder = preResult.get(carName);

        if (isMoving) {
            stringBuilder.append("-");
            moveCountMap.put(carName, moveCountMap.getOrDefault(carName, 0) + 1);
        }
    }

    public static List<String> getWinner(){

        int maxFrequency = 0;
        List<String> winnerList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : moveCountMap.entrySet()) {
            int frequency = entry.getValue();
            if(frequency > maxFrequency){
              maxFrequency = frequency;
              winnerList.clear();
              winnerList.add(entry.getKey());
            }else if (entry.getValue() == maxFrequency){
              winnerList.add(entry.getKey());
            }
      }
        return winnerList;
    }

}

