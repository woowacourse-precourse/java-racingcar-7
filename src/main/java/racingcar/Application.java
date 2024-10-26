package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Input.readCarNames();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfMoves = Input.readNumberOfMoves();

        System.out.println();
        System.out.println("실행 결과");

        int[] carLocations = new int[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            carLocations[i] = 0;
        }

        for (int i = 0; i < numberOfMoves; i++) {
            CarRacing.moveCar(carLocations);
            CarRacing.printCarLocation(carNames, carLocations);
        }

        int max = 0;
        for (int i = 0; i < carNames.length; i++) {
            max = Math.max(max, carLocations[i]);
        }

        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            if (carLocations[i] == max) {
                winners.add(carNames[i]);
            }
        }
        String result = String.join(",", winners);

        System.out.println("최종 우승자 : " + result);
    }
}
