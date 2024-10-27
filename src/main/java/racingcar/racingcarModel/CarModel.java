package racingcar.racingcarModel;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import java.lang.String;
import java.util.HashMap;


public class CarModel {

    // 자동차 이름을 구분하는 메서드
    public LinkedHashMap<String, Integer> initializeCarInfo(String carNames) {
        StringTokenizer st = new StringTokenizer(carNames, ",");
        LinkedHashMap<String, Integer> carInfo = new LinkedHashMap<>();

        while (st.hasMoreTokens()) {
            carInfo.put(st.nextToken(), 0);
        }
        return carInfo;
    }

    // 랜덤값에 따라 전진 여부를 결정하는 메서드
    public int isForward(int currentValue) {

        int i = Randoms.pickNumberInRange(0, 9);

        if (i >= 4) {
            return currentValue + 1;
        }
        return currentValue;
    }

    // 맵 내 최대 value를 구하는 메서드
    public int maxValue(LinkedHashMap<String, Integer> carInfo) {
        int maxValue = 0;

        for (HashMap.Entry<String, Integer> entry : carInfo.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }
        return maxValue;
    }

    // 맵 내 최대 value를 지닌 값의 key를 구해서 String으로 합하는 메서드
    public String winnerCar(LinkedHashMap<String, Integer> carInfo, int maxValue) {
        StringBuilder winner = new StringBuilder();

        for (HashMap.Entry<String, Integer> entry : carInfo.entrySet()) {
            if (maxValue <= entry.getValue()) {
                appendWinner(winner, entry.getKey());
            }
        }

        return winner.toString();
    }

    // 승자가 두 명 이상이면 사이에 콤마를 붙여주는 메서드
    public void appendWinner(StringBuilder winner, String key) {
        if (winner.length() > 0) {
            winner.append(", ");
        }
        winner.append(key);
    }

}


