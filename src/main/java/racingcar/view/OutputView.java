package racingcar.view;

public class OutputView {
    public static void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void requestAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printBeginRace() {
        System.out.print("실행 결과");
    }

    public static void printRaceStatus(String carName, int advanceCount) {
        System.out.print("\n" + carName + " : ");

        for (int i = 0; i < advanceCount; i++) {
            System.out.print("-");
        }
    }

    public static void printNewLine() {
        System.out.println();
    }
}
