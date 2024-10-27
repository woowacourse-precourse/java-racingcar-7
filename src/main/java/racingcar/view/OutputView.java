package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class OutputView {

    public static void resultMessage() {
        System.out.println("\n실행 결과");
    }

    public static String positionToDash(int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    public static void printCarPositions(RacingGame racingGame) { //데이터 받을 따 컨트롤러 통해서
        for (Car car : racingGame.getCars()) {
            System.out.println(car.getName() + " : " + positionToDash(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinnerName(List<String> name) {
        if (name.size() > 1) {
            String winnerNames = String.join(",");
            System.out.println("최종 우승자 : " + winnerNames);
            return;
        }
        System.out.println("최종 우승자 : " + name.get(0));
    }
}
