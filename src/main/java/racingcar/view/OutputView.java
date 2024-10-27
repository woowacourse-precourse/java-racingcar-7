package racingcar.view;

public class OutputView {
    public static void printTurnResult(String name, String score) {
        System.out.println(name + " : " + score);
    }

    public static void printResultSentence() {
        System.out.println("");
        System.out.println("실행 결과");
    }

    public static void printEmpty() {
        System.out.println("");
    }

    public static void printWinnerSentence() {
        System.out.print("최종 우승자 : ");
    }

    public static void printWinner(String s) {
        System.out.print(s);
    }

    public static void printRest() {
        System.out.print(", ");
    }
}
