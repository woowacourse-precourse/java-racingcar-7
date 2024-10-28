package racingcar.view;

import static racingcar.view.Message.*;

import java.util.List;
import racingcar.Entity.Car;

/**
 * 사용자에게 정보를 출력하는 역할을 담당하는 클래스입니다.
 * 자동차 경주 게임의 각 단계별 결과와 최종 우승자, 에러 메시지를 출력합니다.
 */
public class OutputView {

    /**
     * 자동차 이름 입력 안내 메시지를 출력합니다.
     */
    public static void printEnterCarNames() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    /**
     * 이동 횟수 입력 안내 메시지를 출력합니다.
     */
    public static void printEnterMoveCount() {
        System.out.println(COUNT_MESSAGE);
    }

    /**
     * 경주 결과를 출력합니다.
     * 각 라운드별로 모든 자동차의 현재 위치를 "-"로 시각화하여 출력합니다.
     *
     * @param history 각 라운드별 자동차들의 상태를 저장한 리스트
     */
    public static void printGameResult(List<List<Car>> history) {
        // 라운드 결과 시작 메시지 출력
        System.out.println(ROUND_RESULT_MESSAGE);

        // 각 라운드별로 자동차의 위치를 출력
        for (List<Car> round : history) {
            for (Car car : round) {
                // 자동차 이름과 현재 위치를 "-"로 시각화하여 출력
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()) + " ");
            }
            // 라운드가 끝난 후 빈 줄 출력
            System.out.println();
        }
    }

    /**
     * 최종 우승자를 출력합니다.
     * 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력합니다.
     *
     * @param winners 최종 우승자 자동차들의 리스트
     */
    public static void printWinners(List<Car> winners) {
        // 우승자 이름들을 쉼표로 구분하여 하나의 문자열로 생성
        String winnerNames = String.join(", ", winners.stream().map(Car::getName).toList());
        // 최종 우승자 메시지와 함께 우승자 이름 출력
        System.out.println(FINAL_WINNER_MESSAGE + winnerNames);
    }

    /**
     * 에러 메시지를 출력합니다.
     *
     * @param message 출력할 에러 메시지
     */
    public static void printError(String message) {
        System.out.println(message);
    }
}
