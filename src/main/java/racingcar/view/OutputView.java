package racingcar.view;

public class OutputView {
    public static void requestCarName () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void requestTryNumber () {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printCarState (String carName, String location) {
        System.out.println(carName + " : " + location);
    }

    public static void printNewLine () {
        System.out.println();
    }

    public static void printWinner (String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
