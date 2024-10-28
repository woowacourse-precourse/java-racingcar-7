package racingcar.io;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.Car;

public class Printer {
    private final String WOOWA_SCORE_TYPE = "-";
    private final String WOOWA_RESULT_DELIMITER = " : ";
    private final Character NEWLINE = '\n';
    private final String WOOWA_FINAL_FORMAT = "최종 우승자 : ";
    private final String WOOWA_FINAL_DELIMITER = ", ";

    public void printRoundResult(List<Car> roundResult) { // 쌍으로 이루어지는가? -> Stream API는 입력 컬렉션의 순서를 유지한다.
        List<String> roundResultNames = roundResult.stream()
                .map(Car::getUserName)
                .collect(Collectors.toList());

        List<Integer> roundResultScore = roundResult.stream()
                .map(car -> car.getScore().getScore())
                .collect(Collectors.toList());

        IntStream.range(0, roundResult.size())
                .forEach(index -> System.out.print(roundResultNames.get(index)
                        + WOOWA_RESULT_DELIMITER + WOOWA_SCORE_TYPE.repeat(roundResultScore.get(index)) + NEWLINE));
        System.out.println();
    }

    public void printFinalResult(List<String> finalResult) {
        String result = finalResult.stream()
                .collect(Collectors.joining(WOOWA_FINAL_DELIMITER));

        System.out.println(WOOWA_FINAL_FORMAT + result);
    }
}