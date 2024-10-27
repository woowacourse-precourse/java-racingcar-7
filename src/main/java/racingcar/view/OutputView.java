package racingcar.view;

public class OutputView {

    public void displayProgress(String car, String dashCount) {
        System.out.println(car + " : " + dashCount);
    }

    public void displayResult(StringBuilder sb) {
        System.out.println("최종 우승자 : " + sb.toString());
    }
}
