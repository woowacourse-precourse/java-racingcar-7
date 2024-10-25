package racingcar.view;

import java.util.List;
import java.util.Map;


// 클래스를 받는게 나을까, Hash로 받는게 나을까?
public class OutputView {
    public static void printProgress(Map<String, Integer> raceStatus) {
        for (String car : raceStatus.keySet()) {
            System.out.print(car + " : ");
            int progress = raceStatus.get(car);
            for (int i = 0; i < progress; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printResult(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ",winners));
    }
}
