package racingcar.view;

public class OutputView {

    public static void promptCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void promptTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void promptMoveCar() {
        System.out.println("\n실행 결과");
    }

    public static void printMoveCar() {
        System.out.print("-");
    }

    public static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    public static void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
