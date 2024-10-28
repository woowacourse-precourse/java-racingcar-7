package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;;

public class OutputView {

    public static void resultMessage() {
        System.out.println("\n실행 결과");
    }

    public static String positionToDash(int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    public static void printRacingCar(String name, int position) {
        System.out.println(name + " : " + positionToDash(position));
    }

    public static void printWinnerName(List<String> name) {
        if (name.size() > 1) {
            String winnerNames = String.join(",");
            System.out.println("\n최종 우승자 : " + winnerNames);
            return;
        }
        System.out.println("\n최종 우승자 : " + name.getFirst());
    }
}
