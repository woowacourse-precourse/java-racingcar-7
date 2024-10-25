package racingcar;

public class OutputView {
    void printResultMessage(String name, Integer number) {
        System.out.print(name + " " + ":" + " ");
        for (int i = 0; i < number; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
