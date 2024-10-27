package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            // 1. 자동자 이름 입력 및 검증
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            List<String> carNames = CarNameValidator.getCarNames(Console.readLine());

            // 2. 이동 횟수 입력 및 검증
            System.out.println("시도할 횟수는 몇 회인가요?");
            int moveCount = MoveCountValidator.getMoveCount(Console.readLine());

            // 3. 경주 진행
            List<Integer> positions = new ArrayList<>(carNames.size());
            for (int i = 0; i < carNames.size(); i++) positions.add(0); // 초기 위치 설정

            for (int i = 0; i < moveCount; i++) {
                for (int j = 0; j < carNames.size(); j++) {
                    if (MoveCondition.canMove()) {
                        positions.set(j, positions.get(j) + 1);
                    }
                }
                RaceResultPrinter.printRoundResult(carNames, positions);    // 매 라운드 결과 출력
            }

            // 4. 우승자 결정 및 출력
            List<String> winners = WinnerDeterminer.determineWinners(carNames, positions);
            WinnerDeterminer.printWinners(winners);

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
