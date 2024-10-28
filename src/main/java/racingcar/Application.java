package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        CarNameParser carNameParser = new CarNameParser(promptCarName());
        RaceManager raceManager = new RaceManager(carNameParser.getCarNames(), promptRaceRound());
        RaceWinnerDeterminer raceWinnerDeterminer = new RaceWinnerDeterminer(carNameParser.getCarNames(), raceManager.getCurrentScores());
    }

    private static String promptCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames;
        try {
            carNames = Console.readLine();
        } catch (NoSuchElementException e) {
            System.out.println("올바른 자동차 이름을 입력해 주세요");
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    private static int promptRaceRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int raceRound;
        try {
            raceRound = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요");
            throw new IllegalArgumentException();
        }
        if (raceRound <= 0) {
            System.out.println("1회 이상 입력해주세요");
            throw new IllegalArgumentException();
        }
        return raceRound;
    }
}
