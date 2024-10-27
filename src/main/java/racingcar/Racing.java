package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {

    private List<String> carNames;
    private int tryCount;
    private int[] carPositions;

    public Racing(List<String> carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
        this.carPositions = new int[carNames.size()];
    }

    public void startRace() {
        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < carNames.size(); j++) {
                System.out.print(carNames.get(j).trim() + ": ");
                int randomNumber = randomNumber();

            // 0에서 3일 경우는 멈춤, 4에서 9일 경우 전진
            if (randomNumber >= 4) {
                carPositions[j]++;  // 전진 시 자동차의 위치를 증가
            }

            advance(carPositions[j]);
            System.out.println();
        }
    }

    // 0에서 9사이의 랜덤 값 구하기
    public int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 전진 시 "-" 출력
    public void advance(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}

