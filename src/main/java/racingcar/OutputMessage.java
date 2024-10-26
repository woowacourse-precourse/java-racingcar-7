package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputMessage {
    DataManagement dataManagement = new DataManagement();
    Map<String, String> currentCarData = dataManagement.getCarData();
    List<String> winners = dataManagement.getWinners();

    public void printRaceResult(String carName) {
        System.out.println(carName + " : " + currentCarData.get(carName));
    }

    public void printWinners() {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
