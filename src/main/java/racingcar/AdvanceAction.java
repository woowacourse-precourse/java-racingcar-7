package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class AdvanceAction {
    public Map<String, String> setCarList = new HashMap<>(); // 받아올 변수 선언
    public String[] carList;
    private int maxDistance = 0;
    private String winner;

    public void setFirst(String[] carList) {
        this.carList = carList;
        for (String car : carList) {
            setCarList.put(car, "");
        }
    }

    public boolean checkUpperFour() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum >= 4;
    }

    public void updateCarDistance(String car) {
        String tmp = setCarList.get(car);
        tmp += "-";
        setCarList.put(car, tmp);
    }

    public void moveEachCar() {
        for (String car : carList) {
            if (checkUpperFour()) {
                updateCarDistance(car);
            }
            System.out.println(car + " : " + setCarList.get(car));
        }
    }

    public void printCarProgress(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("실행 결과\n");
            moveEachCar();
        }
    }

    public int findMaxDistance() {
        return setCarList.values().stream().mapToInt(String::length).max().orElse(0);
    }

    private void appendWinnerName(StringBuffer stringBuffer, Map.Entry<String, String> entry) {
        if (entry.getValue().length() == maxDistance) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(entry.getKey());
        }
    }

    private String getWinnerNames() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : setCarList.entrySet()) {
            appendWinnerName(stringBuffer, entry);
        }
        return stringBuffer.toString();

    }

    public void printWinner() {
        maxDistance = findMaxDistance();
        String winnerNames = getWinnerNames();
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
