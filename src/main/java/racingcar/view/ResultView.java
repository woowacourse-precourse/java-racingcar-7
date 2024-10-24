package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class ResultView {
    private final StringBuilder sb = new StringBuilder();


    public void saveResult(String result) {
        sb.append(result);
    }

    public void printRaceResult() {
        System.out.println("실행 결과");
        System.out.println(sb);
    }

    public void printWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        winners.forEach(car -> sb.append(car.getName()).append(", "));
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
