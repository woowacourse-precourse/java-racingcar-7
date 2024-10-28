package racingcar.view;

import java.util.Iterator;
import java.util.List;
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
        System.out.println();
    }

    public static void printWinner(List<String> input) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = input.iterator();
        sb.append("최종 우승자 : ");
        while(it.hasNext()) {
            sb.append(it.next());
            if(it.hasNext()) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }

    private static String printForwardCount(int input) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
