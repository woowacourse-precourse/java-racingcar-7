package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CarRaceView {

    private CarRaceView() {
    }

    public static UserRaceSettingDto receiveRaceInfoFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        final int tryRace = Integer.parseInt(Console.readLine());

        return new UserRaceSettingDto(carNames, tryRace);
    }

    public static void displayRaceStatus(final Map<String, Integer> raceStatus) {
        for (final Entry<String, Integer> raceStatusEntry : raceStatus.entrySet()) {
            final String carName = raceStatusEntry.getKey();
            final int forwardCount = raceStatusEntry.getValue();
            System.out.println(carName + " : " + "-".repeat(forwardCount));
        }
        System.out.println();
    }

    public static void displayWinningCar(final List<String> winningCars) {
        final String winningCarNames = String.join(", ", winningCars);
        System.out.println("최종 우승자 : " + winningCarNames);
    }
}
