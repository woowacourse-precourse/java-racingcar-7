package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static final int MAX_GAME_COUNT = 10;
    private static final String START_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_TIME_TEXT = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_START_TEXT = "실행 결과";

    public static void main(String[] args) {
        final Car[] cars = getCars();
        int gameTimes = getGameTimes();
        playGame(cars, gameTimes);

    }

    private static Car[] getCars() {
        List<String> carNames = splitCarNames();
        RegistrationManager manager = new RegistrationManager(carNames);
        manager.checkValidCarNames();
        manager.checkDuplicatePlayer();
        manager.checkValidCarCount();
        return manager.getRegisteredPlayers();
    }

    private static List<String> splitCarNames() {
        System.out.println(START_TEXT);
        String inputString = getInput();
        return Arrays.asList(inputString.split(",", 0));
    }

    private static String getInput() {
        final String input = Console.readLine();
        return input;
    }


    private static int getGameTimes() {
        System.out.println(GAME_TIME_TEXT);
        int gameTimes;
        try {
            gameTimes = Integer.parseInt(getInput());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 횟수로는 숫자만 입력할 수 있습니다.");
        }
        isValidTimes(gameTimes);
        return gameTimes;
    }

    private static void isValidTimes(final int times) {
        if (times < 1 || times > MAX_GAME_COUNT) {
            throw new IllegalArgumentException("최대 게임 횟수는 10번입니다.");
        }
    }

    private static void playGame(Car[] cars, int times) {
        Judgement judgement = new Judgement(cars);
        System.out.println("\n" + RESULT_START_TEXT);
        for (int i = 0; i < times; i++) {
            List<Integer> randomNumbers = getRandomNumbers(cars.length);
            judgement.updateRoundResult(randomNumbers);
        }
        judgement.printWinner();
    }

    private static List<Integer> getRandomNumbers(int carNumbers) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carNumbers; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
        return randomNumbers;
    }
}