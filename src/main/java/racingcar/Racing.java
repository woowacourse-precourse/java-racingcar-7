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
            runOneRound();
        }
    }

    private void runOneRound() {
        System.out.println();
        for (int j = 0; j < carNames.size(); j++) {
            String carName = carNames.get(j).trim();
            System.out.print(carName + " : ");
            moveCar(j);
            advance(carPositions[j]);
            System.out.println();
        }
    }

    private void moveCar(int carIndex) {
        int randomNumber = randomNumber();
        if (randomNumber >= 4) {
            carPositions[carIndex]++;
        }
    }

    public void winners() {
        int maxPosition = findMaxPosition();
        List<String> winners = findWinners(maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> findWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            if (carPositions[i] == maxPosition) {
                winners.add(carNames.get(i));
            }
        }
        return winners;
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