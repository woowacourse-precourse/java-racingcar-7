package racingcar.view;

import java.util.List;
import racingcar.model.RacingInfo;

public class OutputView {

    public static void resultOutput() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static List<String> cars = RacingInfo.cars;
    public static void racingProgressOutput(List<Integer> distance) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i) + " : " + "-" .repeat(Integer.parseInt(String.valueOf(distance.get(i)))));
        }
        System.out.println();
    }

    public static void winnerOutput(List<String> winners) {
        // winners 리스트의 요소를 쉼표로 구분하여 하나의 문자열로 만듦
        String result = String.join(", ", winners);

        // 우승자 출력
        System.out.println("최종 우승자 : " + result);
    }
}
