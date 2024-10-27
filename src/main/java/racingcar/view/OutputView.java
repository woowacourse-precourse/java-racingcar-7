/*
 * OutputView
 *
 * ver1
 *
 * 2024-10-24
 *
 * 저작권 주의
 */
package racingcar.view;

public class OutputView {
    private static final String READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String READ_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printRacingCarsState(String states) {
        System.out.println(states);
    }

    public void printReadCarNameMessage() {
        System.out.println(READ_CAR_NAME_MESSAGE);
    }

    public void printReadNumberOfAttempts() {
        System.out.println(READ_NUMBER_OF_ATTEMPTS);
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printWinners(String winners) {
        System.out.print(WINNER_MESSAGE + winners);
    }
}
