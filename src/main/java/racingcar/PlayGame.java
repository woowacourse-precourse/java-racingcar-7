package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class PlayGame {
    // 랜덤한 값 반환 하는 함수
    // 여러대의 자동차를 배열에 담음
    // 각 요소에 접근
    // 0 ~ 3이면 멈춤, 4 ~ 9 전진
    public static final int MINIMUM_VALUE_CAR_MOVE = 4;
    InputMessage inputMessage = new InputMessage();
    Map<String, String> carData = new HashMap<>();

    public int returnRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void racingCarCreate(String[] carNames){
        for (String carName : carNames) {
            this.carData.put(carName, "");
        }
    }

    public void moveCars(String[] carNames) {
        for (String carName : carNames) {
            // 무작위 수 구하기
            int randomNumber = returnRandomNumber();

            if (randomNumber >= MINIMUM_VALUE_CAR_MOVE) {
                String currentDistance = this.carData.get(carName);
                this.carData.put(carName, currentDistance + "-");
            }
        }
    }

    public void run(){
        String carName = inputMessage.inputCarName();
        String[] carNames = inputMessage.splitCarName(carName, ",");
        racingCarCreate(carNames);
        moveCars(carNames);
    }
}
