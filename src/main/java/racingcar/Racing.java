package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {

    private List<String> carNames;

    public Racing(List<String> carNames) {
        this.carNames = carNames;
    }
    public void startRace() {
        System.out.println("실행 결과");
        for (String name : carNames) {
            System.out.print(name.trim() + ": ");
            int randomNumber = randomNumber();

            // 0에서 3일 경우는 멈춤, 4에서 9일 경우 전진
            if (randomNumber >= 4) {
                advance(1);  // 전진일 때 '-' 출력
            }

            System.out.println();
        }
    }

    // 0에서 9사이의 랜덤 값 구하기
    public int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 전진 시 "-" 출력
    public void advance(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }

    public static void main(String[] args) {
        int tryCount = 0;
        while (tryCount-1 > 0) {
            tryCount --;
        }   System.out.println();
    }
}

