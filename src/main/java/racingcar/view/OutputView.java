package racingcar.view;

import racingcar.domain.Cars;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    //현재 상태 출력
    public void printStatus(Cars cars) {
        cars.getCars().entrySet().stream()
                .forEach(entry -> {
                    String carName = entry.getKey();
                    Integer distance = entry.getValue();
                    System.out.println(carName + " : " + "-".repeat(distance));
                });
        System.out.println();
    }

    //우승자 결과 출력
    public void printResult(List<String> winners) {
        System.out.println("최종 우승자 : " + winners.stream()
                .collect(Collectors.joining(", ")));
    }
}
