package racingcar.output.process;

import java.util.Map;

public class ProcessOutputHandlerImpl implements ProcessOutputHandler {
    @Override
    public void printFirstPhrase() {
        System.out.print("\n실행 결과");
    }

    @Override
    public void printHistory(Map<String, Integer> history) {
        System.out.println(); // 각 시도마다 실행 결과 구분을 위한 개행
        for (Map.Entry<String, Integer> entry : history.entrySet()) {
            String carName = entry.getKey();
            int distance = entry.getValue();

            String progressBar = "-".repeat(Math.max(0, distance));

            System.out.println(carName + " : " + progressBar);
        }
    }
}
