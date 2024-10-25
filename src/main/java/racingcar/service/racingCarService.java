package racingcar.service;

import static racingcar.RacingCarConstants.MOVING_FORWARD;
import static racingcar.RacingCarConstants.STOP;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.validator.Validator;

public class racingCarService {

    public static void makeCarMap(String[] cars, Validator validator, Map<String, String> carMoveMap) {
        for(String car : cars) {
            car = car.trim(); //앞 뒤 공백 제거
            Boolean carNameLengthValidate = validator.carNameLengthValidate(car);
            Boolean delimiterValidate = validator.delimiterValidate(car);
            if (delimiterValidate && carNameLengthValidate) {
                carMoveMap.put(car, "");
            } else {
                throw new IllegalArgumentException("레이싱카의 이름의 길이는 5를 넘을 수 없습니다.");
            }
        }
    }

    public static void moveController(String[] cars, Map<String, String> carMoveMap) {
        int randomNum;
        for (String car: cars) {
            randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= MOVING_FORWARD) {
                carMoveMap.put(car, carMoveMap.get(car) + '-');
            } else if (randomNum <= STOP) {
                continue;
            }
        }
    }

    public static ArrayList<String> findWinners(Map<String, String> carMoveMap) {
        ArrayList<String> winners = new ArrayList<>();
        int winnerPosition = 0;

        for (Entry<String, String> items : carMoveMap.entrySet()) {
            int position = items.getValue().length();

            if (position > winnerPosition) {
                winnerPosition = position;
                winners.clear();
                winners.add(items.getKey());
            } else if (position == winnerPosition) {
                winners.add(items.getKey());
            } else {
                continue;
            }
        }

        return winners;
    }
}
