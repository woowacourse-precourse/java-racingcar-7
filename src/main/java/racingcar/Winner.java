package racingcar;

import java.util.List;
import java.util.Map;

public class Winner {
    DataManagement dataManagement = new DataManagement();

    List<String> winners = dataManagement.getWinners();
    Map<String, String> currentCarData = dataManagement.getCarData();

    OutputMessage outputMessage = new OutputMessage();

    InputMessage inputMessage = new InputMessage();
    String[] carNames = dataManagement.splitCarNames();

    int maxDistance = 0;

    public void cowinner(String carName) {
        if (finalDistanceMeasurement(carName) == maxDistance) {
            winners.add(carName);  // 우승자 추가
        }
    }

    public int finalDistanceMeasurement(String carName){
        return currentCarData.get(carName).length();
    }

    public void whoMaxDistance(String carName) {
        if (finalDistanceMeasurement(carName) > maxDistance) {
            maxDistance = finalDistanceMeasurement(carName);
        }
    }

    public void whoWinners(){
        for (String carName : carNames) {
            whoMaxDistance(carName);
            cowinner(carName);
        }
        outputMessage.printWinners();
    }
}
