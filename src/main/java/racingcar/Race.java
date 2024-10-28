package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Race {

    private StringBuilder result = new StringBuilder();

    public void raceStart(String[] names, String count) {
        int tryCount = Integer.parseInt(count);
        checkInput(names, tryCount);

        Map<String, Integer> raceMap = new HashMap<>();
        for (String name : names) {
            raceMap.put(name, 0);
        }

        for (int i = 0; i < tryCount; i++) {
            moveCar(raceMap);
            saveResult(raceMap);
        }

        saveWinner(raceMap);
        System.out.println(result);
    }

    private void moveCar(Map<String, Integer> raceMap) {
        for (Map.Entry<String, Integer> entry : raceMap.entrySet()) {
            if (isMoving()) {
                raceMap.put(entry.getKey(), entry.getValue() + 1);
            }
        }
    }

    private boolean isMoving() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    private void saveResult(Map<String, Integer> raceMap) {
        for (Map.Entry<String, Integer> entry : raceMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            result.append(saveLog(sb, entry)).append("\n");
        }
        result.append("\n");
    }

    private String saveLog(StringBuilder sb, Map.Entry<String, Integer> entry) {
        sb.append(entry.getKey());
        sb.append(" : ");
        for (int i = 0; i < entry.getValue(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    private void saveWinner(Map<String, Integer> raceMap) {
        int maxMove = Collections.max(raceMap.values());
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : raceMap.entrySet()) {
            if (entry.getValue() == maxMove) {
                sb.append(entry.getKey());
                sb.append(", ");
            }
        }

        result.append("최종 우승자 : ").append(sb.substring(0, sb.length() - 2)).append("\n");
    }

    // ============= 입력값 검증 메서드 =============

    private void checkInput(String[] names, int count) {
        for (String name : names) {
            checkIfLengthExceed(name);
        }

        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수를 알맞게 입력해 주세요.");
        }
    }

    private void checkIfLengthExceed(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("각 이름은 최대 5자 이하여야 합니다.");
        }
    }
}
