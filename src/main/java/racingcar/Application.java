package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        List<String> splitCarNames = new ArrayList<>(List.of(carName.split(",")));
        List<Integer> carMovementCounts = new ArrayList<>();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int trial = Integer.parseInt(Console.readLine());

        for (int i = 0; i < splitCarNames.size(); i++) {

            if (splitCarNames.get(i).length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5자입니다.");
            }

            carMovementCounts.add(0); // 각 이름의 초기 이동 값을 0으로 설정
        }

        System.out.println("실행 결과");
        // 각 라운드별 "-" 출력
        for (int i = 1; i <= trial; i++) {
            round(splitCarNames, carMovementCounts);
            System.out.println(); // 각 라운드 후 빈 줄 추가
        }

        // 가장 "-"의 개수가 많은 자동차
        winner(splitCarNames, carMovementCounts);
    }

    // 주어진 라운드에 따라 '-' 출력
    private static void round(List<String> carNames, List<Integer> carMovementCounts) {

        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                carMovementCounts.set(i, carMovementCounts.get(i) + 1); // 누적 이동 값 증가
            }

            // 누적된 "-" 값 출력
            System.out.println("-".repeat(carMovementCounts.get(i)));
        }
    }

    private static void winner(List<String> carNames, List<Integer> carMovementCounts) {

        // "-" 출력이 가장 많은 값
        int maxMoves = carMovementCounts.get(0);

        for (int i = 0; i < carMovementCounts.size(); i++) {
            if (maxMoves < carMovementCounts.get(i)) {
                maxMoves = carMovementCounts.get(i);
            }
        }

        // 공동 우승자
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            if (carMovementCounts.get(i) == maxMoves)
                winners.add(carNames.get(i)); // "-" 출력이 같거나 가장 많은 자동차만 추가
        }

        for (String jointWinners : winners) {
            System.out.println("최종 우승자 : " + jointWinners);
        }
    }
}