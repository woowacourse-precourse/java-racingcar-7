package racingcar.caculator;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class WinnerCaculator {
    // 누적 우승자를 저장할 리스트
    private final List<String> totalWinners = new ArrayList<>();

    public void WinnerResult(List<String> carName, List<Integer> carRandomNumber) {
        Map<String, Integer> playReusult = new HashMap<>();

        // 두 리스트를 value=key 형태로 매핑
        for (int i = 0; i < carName.size(); i++) {
            playReusult.put(carName.get(i), carRandomNumber.get(i));
        }

        //우승자 변수와 최소값 선언
        List<String> winnerName = new ArrayList<>();
        int maxNumber = Integer.MIN_VALUE;

        // HashMap을 순회하며 최대값을 가진 우승자 찾기
        for (Map.Entry<String, Integer> entry : playReusult.entrySet()) {
            if (entry.getValue() > maxNumber) {
                // 새로운 최대값을 찾으면 리스트를 초기화하고 우승자 추가
                winnerName.clear();
                winnerName.add(entry.getKey());
                maxNumber = entry.getValue();
            } else if (entry.getValue() == maxNumber) {
                // 최대값과 동일한 값이 있을 경우 우승자 추가
                winnerName.add(entry.getKey());
            }
        }
        // 현재 실행의 우승자를 누적 리스트에 추가
        totalWinners.addAll(winnerName);

        // 결과 출력
        System.out.println("우승자 : " + totalWinners);
    }
}
