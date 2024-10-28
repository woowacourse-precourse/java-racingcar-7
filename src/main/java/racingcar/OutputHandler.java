package racingcar;

public class OutputHandler {

    public static void printInstructionForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInstructionForTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printInformResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printOneBlankLine() {
        System.out.println();
    }

    public static void printWinner(String result) {
        System.out.println("최종 우승자 : " + result);
    }

    public static void printExecuteResult(String executeResult) {
        System.out.println(executeResult);
    }
}
