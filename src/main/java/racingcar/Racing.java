package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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

    public void startRace() {
        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            System.out.println();

            for (int j = 0; j < carNames.size(); j++) {
                System.out.print(carNames.get(j).trim() + " : ");
                int randomNumber = randomNumber();

                // 0에서 3일 경우는 멈춤, 4에서 9일 경우 전진
                if (randomNumber >= 4) {
                    carPositions[j]++;  // 전진 시 자동차의 위치를 증가
                }

                advance(carPositions[j]);

                System.out.println();
            }
        }
    }
    public void winners() {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();

        // 자동차의 위치가 최대 위치와 같으면 우승자로 추가
        for (int i = 0; i < carNames.size(); i++) {
            if (carPositions[i] == maxPosition) {
                winners.add(carNames.get(i));
            }
        }

        // 우승자 출력
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }


    private int findMaxPosition() {
        int maxPosition = 0;
        for (int position : carPositions) {
            if (position > maxPosition) {
                maxPosition = position;
            }
        }
        return maxPosition;
    }
}