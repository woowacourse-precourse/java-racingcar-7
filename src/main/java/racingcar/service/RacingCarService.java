package racingcar.service;

import racingcar.validator.RandomValidator;

import java.util.Arrays;
import java.util.List;

public class RacingCarService {

  RandomValidator randomValidator = new RandomValidator();

  public List<String> startRace(List<String> carList, int parsedAtmp){

    System.out.println("실행결과\n");

    String[] carRaceResults = new String[carList.size()];
    Arrays.fill(carRaceResults, "");

    for (int i = 0; i < parsedAtmp; i++) {
      for (int j = 0 ; j < carList.size(); j++) {
        if (randomValidator.checkRandomThreshold()) {
          carRaceResults[j] += "-";
        }
        else {
          carRaceResults[j] += "";
        }
        System.out.println(carList.get(j) + " : " + carRaceResults[j]);
      }
      System.out.println("\n");
    }
    List<String> gameResult = Arrays.asList(carRaceResults);
    return getRaceWinner(carList, gameResult);
  }

  public List<String> getRaceWinner(List<String> carList, List<String> gameResult){
    int[] carRaceResults = new int[gameResult.size()];
    for (int i = 0; i < gameResult.size(); i++) {
      carRaceResults[i] = gameResult.get(i).length();
    }

    String[] winners = new String[carList.size()];
    for (int i = 0; i < carRaceResults.length; i++) {
      if (carRaceResults[i] == Arrays.stream(carRaceResults).max().getAsInt()) {
        winners = new String[]{carList.get(i)};
      }
    }
    return Arrays.asList(winners);
  }
}
