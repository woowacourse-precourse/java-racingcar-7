package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Displayer implements DisplayerInterface{
    @Override
    public void showLog(List<List<String>> log) {
        List<String> collector = new ArrayList<>();
        for (List<String> singleTryLogs : log) {
            collector.add(String.join("\n", singleTryLogs));
        }
        System.out.println(String.join("\n\n", collector));
    }

    @Override
    public void showWinner(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(",", winners));
    }
}
