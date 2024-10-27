package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WinnerSelecter {

  public List<String> selectWinner(Map<String, String> carGameRecords) {
    List<String> winnerList = new ArrayList<>();
    int bestRecords = 0;
    for (Map.Entry<String, String> carsRecords : carGameRecords.entrySet()) {
      if (carsRecords.getValue().length() >= bestRecords) {
        bestRecords = carsRecords.getValue().length();
        winnerList.add(carsRecords.getKey());
      }
    }
    return winnerList;
  }
}
