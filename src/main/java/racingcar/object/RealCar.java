package racingcar.object;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RealCar {
    private final String name;           // 자동차 이름 저장
    private String history; // 이동 결과를 담을 리스트
    private static final int MOVE_THRESHOLD = 4; // 이동 판별을 위한 기준

    // 생성자: 자동차 이름을 받아서 초기화
    public RealCar(String name) {
        this.name = name;
        this.history = "";
    }

    // 이동 여부를 판별하는 메서드
    public void moveCar() {
        int randomValue = Randoms.pickNumberInRange(0, 9); // 0에서 9 사이의 숫자 생성
        if (randomValue >= MOVE_THRESHOLD) {
            history = history.concat("-"); // 이동하면 1 추가
        }
    }

    // 현재까지의 이동 결과 반환
    public void getMoveHistory() {
        System.out.println(this.name + " : " +this.history);
    }

    // 자동차 이름 반환
    public String getCarName() {
        return name;
    }

    //몇 번 움직였는지
    public Integer getRaceTimes() {
        return history.length();
    }

    // 승리한 자동차 출력
    public void printResult(int result) {
        if(history.length() == result) {
            System.out.println(this.name);
        }
    }
}