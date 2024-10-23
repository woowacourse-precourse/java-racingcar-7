package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    // 랜덤한 값 반환 하는 함수
    // 여러대의 자동차를 배열에 담음
    // 각 요소에 접근
    // 0 ~ 3이면 멈춤, 4 ~ 9 전진
    public static final int MINIMUM_VALUE_CAR_MOVE = 4;
    InputMessage inputMessage = new InputMessage();
    Map<String, String> carData = new HashMap<>();
    int maxDistance = 0;

    public void racingCarCreate(String[] carNames){
        for (String carName : carNames) {
            this.carData.put(carName, "");
        }
    }

    public void moveCars(String[] carNames) {
        for (String carName : carNames) {
            // 무작위 수 구하기
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= MINIMUM_VALUE_CAR_MOVE) {
                String currentDistance = this.carData.get(carName);
                this.carData.put(carName, currentDistance + "-");
            }
        }
    }

    public void printRaceResult(String[] carNames) {
        for (String carName : carNames) {
            System.out.println(carName + " : " + this.carData.get(carName));
        }
        System.out.println();
    }

    public int getMaxDistance(String[] carNames) {
        for (String carName : carNames) {
            int currentDistance = this.carData.get(carName).length();
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
            }
        }
        return maxDistance;
    }

    public List<String> getWinners(String[] carNames) {
        List<String> winners = new ArrayList<>();
        for (String carName : carNames) {
            int currentDistance = carData.get(carName).length();
            if (currentDistance == maxDistance) {
                winners.add(carName);  // 우승자 추가
            }
        }
        return winners;
    }

    public void racingStart(){
        String carName = inputMessage.inputCarName();
        String[] carNames = inputMessage.splitCarName(carName, ",");
        String tryCarGame = inputMessage.inputNumberOfTries();

        racingCarCreate(carNames);

        for(int i=0; i<Integer.parseInt(tryCarGame); i++){
            moveCars(carNames);
            printRaceResult(carNames);
        }

        getMaxDistance(carNames);
        getWinners(carNames);
    }
}
