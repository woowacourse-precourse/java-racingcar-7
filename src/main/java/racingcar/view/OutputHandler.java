package racingcar.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class OutputHandler {
    public void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");
        printList(winner);
    }

    public void printList(List<String> list) {
        for (String str : list) {
            System.out.print(str);
            if (!list.getLast().equals(str)) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void printProcess(HashMap<String, Integer> process) {
        for (Entry<String, Integer> pro : process.entrySet()) {
            System.out.print(pro.getKey());
            System.out.print(" : ");
            System.out.print("-".repeat(pro.getValue()));
            System.out.println();
        }
        System.out.println();
    }
}
