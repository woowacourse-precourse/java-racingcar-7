package racingcar;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
    }
}

//n대의 자동차 입력받고 저장하기
//주어진 횟수(이동 횟수) 입력받고 저장하기
//자동차 전진 또는 멈춤(랜덤값)
//차수별 실행 결과 출력하기
//우승자 출력하기
//예외 처리
class Racingcar {
    HashMap<String, Integer> carMove = new HashMap<String, Integer>(); // (자동차 이름: 현재 위치)
    int moveCnt;

    void inputCar(final String text) {
        for(final String carName : text.split(",")) {
            carMove.put(carName, 0);
        }
    }

    void inputCnt(final int cnt) {
        moveCnt = cnt;
    }

    void race(HashMap<String, Integer> carMove) {
        for(Map.Entry<String, Integer> curCar : carMove.entrySet()) {
            curCar.setValue(curCar.getValue() + pickNumberInRange(0, 9)); // 10까지 범위인지를 모르겠음.
        }
    }

    void totalRace(final int moveCnt) {
        for (int i = 0; i < moveCnt; i++) {
            race(carMove);
        }
    }

    void raceResult(HashMap<String, Integer> carLocation) {
        for(Map.Entry<String, Integer> curCar : carLocation.entrySet()) {
            String carName = curCar.getKey();
            int move = curCar.getValue();
            System.out.println(carName + ":" + "-".repeat(move));
        }
    }

}