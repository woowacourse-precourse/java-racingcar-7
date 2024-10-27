package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final String START_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_TIME_TEXT = "시도할 횟수는 몇 회인가요?";

    private static final int MAX_GAME_COUNT = 10;

    private static String getInput(){
        String inputString = Console.readLine();
        return inputString;
    }

    private static ArrayList<String> splitCarNames(String input){
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",",0)));
        return carNames;
    }


    private static registraionManager getCarNames(){
        System.out.println(START_TEXT);
        String inputString = getInput();
        ArrayList<String> carNames = splitCarNames(inputString);
        registraionManager manager = new registraionManager(carNames);
        manager.checkValidCarNames();
        manager.checkDuplicatePlayer();
        manager.checkValidCarCount();
        return manager;
    }

    private static void isValidTimes(final int times){
        if ((times < 1) || (times > MAX_GAME_COUNT)){
            throw new IllegalArgumentException("최대 게임 횟수는 10번입니다.");
        }
    }

    private static int getGameTimes(){
        System.out.println(GAME_TIME_TEXT);
        final int GAME_TIMES;
        String timesString = getInput();
        try{
            GAME_TIMES = Integer.parseInt(timesString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 횟수로는 숫자만 입력할 수 있습니다.");
        }
        isValidTimes(GAME_TIMES);
        return GAME_TIMES;
    }

    private static ArrayList<Integer> getRandomNumbers(int carNumbers){
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for(int i=0; i<carNumbers; i++){
            randomNumbers.add(Randoms.pickNumberInRange(0,9));
        }
        return randomNumbers;
    }

    private static void playGame(registraionManager manager, int times){
        ArrayList<Integer> randomNumbers;
        judgement judgement = new judgement(manager.getRegisteredPlayers());

        for(int i=0; i<times; i++){
            randomNumbers = getRandomNumbers(manager.getRegisteredPlayersCount());
            judgement.updateResult(randomNumbers);
        }
        judgement.printWinner();
    }

    public static void main(String[] args) {
        registraionManager manager = getCarNames();
        int gameTimes = getGameTimes();
        playGame(manager, gameTimes);
    }
}
