package racingcar.console;

import racingcar.value.Player;
import racingcar.value.RacingCar;
import racingcar.value.RacingCarList;
import racingcar.value.WinnerPlayerList;

import java.util.stream.Collectors;
import java.util.stream.Stream;

final class OutputService {
    private OutputService() {
    }

    public static OutputService init() {
        return new OutputService();
    }

    public void printInputRacingCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputTotalLaps() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printCurrentLapResult(final RacingCarList racingCarList) {
        final var message = new StringBuilder();
        racingCarList.action(racingCar -> {
            final var playerName = racingCar.getPlayerNameString();
            final var distance = createDistance(racingCar);

            createResultMessage(message, playerName, distance);
        });

        System.out.println(message);
    }

    public void printWinners(final WinnerPlayerList winnerPlayerList) {
        final var message = winnerPlayerList.list().stream()
            .map(Player::name)
            .collect(Collectors.joining(", ", "최종 우승자 : ", ""));

        System.out.println(message);
    }

    public void printStart() {
        System.out.println("실행 결과");
    }

    private static String createDistance(RacingCar e) {
        return Stream.generate(() -> "-")
            .limit(e.getDistance().getValue())
            .collect(Collectors.joining());
    }

    private static void createResultMessage(StringBuilder message, String playerName, String distance) {
        message.append(playerName)
            .append(" : ")
            .append(distance)
            .append(System.lineSeparator());
    }
}