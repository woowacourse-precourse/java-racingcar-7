package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultPrint {

    public static List<String> getResultStrings() {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < RacingProcess.carNumber; i++) {
            results.add(Application.nameList.get(i) + " : " + Application.processResult[i]);
        }
        return results;
    }

    public static void resultPrint() {
        for (String result : getResultStrings()) {
            System.out.println(result);
        }
        System.out.println();
    }
}
