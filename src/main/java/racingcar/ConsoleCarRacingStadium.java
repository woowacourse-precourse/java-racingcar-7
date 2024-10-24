package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.component.RacingCar;
import racingcar.factory.RacingCarFactory;
import racingcar.race.RacingGame;
import racingcar.race.RacingPlayer;

import java.util.List;

public class ConsoleCarRacingStadium {

    RacingGame<RacingCar> racingGame;

    public ConsoleCarRacingStadium() {
        List<RacingPlayer<RacingCar>> racingCars = setUpRacingCars();
        int matchCount = setUpMatchCount();
        this.racingGame = new RacingGame<>(racingCars, matchCount);
        Console.close();
    }

    public void startRace() {
        racingGame.play();
        List<String> namesOfWinner = racingGame.getWinners()
                .stream()
                .map(RacingPlayer::getPlayerName)
                .toList();
        System.out.println("최종 우승자 : " + String.join(", ", namesOfWinner));
    }

    private int setUpMatchCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String matchCountInput = Console.readLine();
        if (!isPositiveNumber(matchCountInput)) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수로 입력하세요.");
        }
        return Integer.parseInt(matchCountInput);
    }

    private boolean isPositiveNumber(String number) {
        try {
            int parsedInt = Integer.parseInt(number);
            return parsedInt > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private List<RacingPlayer<RacingCar>> setUpRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        RacingCarFactory racingCarFactory = new RacingCarFactory(carNamesInput);

        return racingCarFactory.createRacingCars()
                .stream()
                .map((racingCar) -> (RacingPlayer<RacingCar>) racingCar)
                .toList();
    }

}
