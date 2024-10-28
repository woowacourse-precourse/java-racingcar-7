package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Methods {

    // 자동차의 현재 위치를 담는 map 생성
    private Map<String, StringBuilder> carConditions = new HashMap<>();

    // 자동차 이름 조건 체크 후 조건에 부합하면 다음 메서드로 반납
    public List<String> nameCheck(String inputCarNames) {

        List<String> nameList = new ArrayList<>();

        String[] carNameArr = inputCarNames.split(",");
        for (String carName : carNameArr) {
            if (carName.length() < 5) {
                nameList.add(carName);
                carConditions.put(carName, new StringBuilder());
            } else {
                throw new IllegalArgumentException(" 자동차 이름은 5자 이하로 작성해야합니다.");
            }
        }

        return nameList;
    }

    // 전진 메소드
    private void isMoving(String carName) {

        int randomNum = pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            carConditions.get(carName).append("-");
        }

    }


    //각 자동차의 현재 스코어 메소드
    private void currentScore() {
        for (String carName : carConditions.keySet()) {
            System.out.println(carName + " : " + carConditions.get(carName).toString());
        }
        System.out.println();
    }


    // 입력받은 tryCount 이용해 카레이싱 메소드
    public void carRacing(String inputTryCount, List<String> nameList) {

        int tryCount = Integer.parseInt(inputTryCount);
        for (int cnt = 0; cnt < tryCount; cnt++) {
            for (String carName : nameList) {
                isMoving(carName);
            }
            currentScore();
        }
    }

    //우승자
    public void printWinners() {

        int maxDistance = 0;
        for (StringBuilder distance : carConditions.values()) {
            int length = distance.length();
            if (length > maxDistance) {
                maxDistance = length;
            }
        }

        List<String> winners = new ArrayList<>();
        for (String carName : carConditions.keySet()) {
            if (carConditions.get(carName).length() == maxDistance) {
                winners.add(carName);
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));

    }
}

