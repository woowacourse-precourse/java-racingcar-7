package racingcar.view;

import java.util.Map;
import java.util.Set;

public class OutputView {

    public static void startPrint() {
        System.out.println("\n실행 결과");
    }

    public static void printRace(Map<String, Integer> input) {
        Set<String> names = input.keySet();
        for (String name : names) {
            System.out.println(name + " : " + printForwardCount(input.get(name)));
        }
    }

    private static String printForwardCount(int input) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
