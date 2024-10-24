package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class PlayGame {

    public static final int MINIMUM_VALUE_CAR_POWER = 4;
    InputMessage inputMessage = new InputMessage();
    Map<String, String> carData = new HashMap<>();
    int maxDistance = 0;
    List<String> winners = new ArrayList<>();

    public void racingRaceParticipation(String[] carNames){
        for (String carName : carNames) {
            goStartingLine(carName);
        }
    }

    public void goStartingLine(String carName){
        carData.put(carName, "");
    }

    public void racingMatchInProgress(String[] carNames) {
        for (String carName : carNames) {
            if (carPower() >= MINIMUM_VALUE_CAR_POWER) {
                moveForward(carName);
            }
        }
    }

    public int carPower(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public String currentDistance(String carName){
        return carData.get(carName);
    }

    public void moveForward(String carName){
        carData.put(carName, currentDistance(carName) + "-");
    }

    public void printRaceResult(String[] carNames) {
        for (String carName : carNames) {
            System.out.println(carName + " : " + carData.get(carName));
        }
        System.out.println();
    }

    public int whoMaxDistance(String[] carNames) {
        for (String carName : carNames) {
            if (finalDistanceMeasurement(carName) > maxDistance) {
                maxDistance = finalDistanceMeasurement(carName);
            }
        }
        return maxDistance;
    }

    public int finalDistanceMeasurement(String carName){
        return carData.get(carName).length();
    }

    public List<String> Winners(String[] carNames) {
        for (String carName : carNames) {
            if (finalDistanceMeasurement(carName) == maxDistance) {
                winners.add(carName);  // 우승자 추가
            }
        }
        return winners;
    }

    public void printWinners() {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void racingStart(){
        String[] carName = inputMessage.inputCarNameReturnSplit(",");
        String tryCarGame = inputMessage.inputNumberOfTries();

        racingRaceParticipation(carName);

        for(int i=0; i<Integer.parseInt(tryCarGame); i++){
            racingMatchInProgress(carName);
            printRaceResult(carName);
        }

        whoMaxDistance(carName);
        Winners(carName);
        printWinners();
    }
}
