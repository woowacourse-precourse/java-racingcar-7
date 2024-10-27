package racingcar.view;

import java.util.List;

public class OutputView {

    public void print(String message) {
        System.out.println(message);
    }

    public void printResult(List<String> status) {
        StringBuilder sb = new StringBuilder();
        print(
                sb.append(status.get(0))
                        .append(" : ")
                        .append("-".repeat(Integer.parseInt(status.get(1))))
                        .toString()
        );
    }
}
