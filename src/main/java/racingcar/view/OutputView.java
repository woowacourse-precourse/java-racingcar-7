package racingcar.view;

import java.util.List;
import java.util.Map;

/**
 * OutputView 클래스는 게임의 실행 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String PARTITION = " : ";   // 이름과 위치를 구분하는 구분자
    private static final String ONE_MOVE = "-";   // 이동을 표현하는 문자열

    /**
     * 에러 메시지를 출력한다.
     */
    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    /**
     * 각 이동 결과를 출력한다.
     */
    public static void printMoveResult(Map<String, Integer> moveResults) {
        System.out.println("\n차수별 실행 결과");   // 결과 출력 시작
        moveResults.keySet().forEach(carName -> printEachMove(carName, moveResults.get(carName)));
    }

    /**
     * 최종 우승자를 출력한다.
     */
    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));   // 각 우승자 이름 출력
            if (i != winners.size() - 1) {
                System.out.print(", ");   // 마지막 우승자 이름에는 쉼표 추가 안 함
            }
        }
    }


    /**
     * 각 차량의 이동 결과를 출력하는 헬퍼 메서드
     */
    private static void printEachMove(String carName, int moveCount) {
        if (moveCount == 0) {   // 이동이 없을 경우 이름만 출력
            System.out.println(carName + PARTITION);
            return;
        }
        System.out.print(carName + PARTITION);   // 이동한 거리를 표시
        for (int i = 0; i < moveCount; i++) {
            System.out.print(ONE_MOVE);   // 이동 거리에 따라 "-" 출력
        }
        System.out.println();
    }
}
