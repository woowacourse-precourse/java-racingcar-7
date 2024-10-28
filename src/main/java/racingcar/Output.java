package racingcar;

import java.util.HashMap;
import java.util.Iterator;

public class Output {
    protected void print(HashMap<String, Integer> result) {
        System.out.print("최종 우승자 : ");

        Iterator<String> iterator = result.keySet().iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.print(name);

            // 다음 요소가 있을 때만 콤마 출력
            if (iterator.hasNext()) {
                System.out.print(", ");
            }
        }
    }

    protected void processPrint(HashMap<String, Integer> process) {
        Iterator<String> iterator = process.keySet().iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.print(name + " : ");
            Integer value = process.get(name);
            for (int i = 0; i < value; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
