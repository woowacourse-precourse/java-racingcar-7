package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class IOHandler {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CYCLE_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String PROCESS_RESULT_MESSAGE = "실행결과";

    public static List<String> setRacerList() {
        System.out.println(START_MESSAGE);
        List<String> racerList = Arrays.asList(Console.readLine().split(","));
        Validator.validateName(racerList);
        return racerList;
    }

    public static int setRaceCycle() {
        System.out.println(INPUT_CYCLE_MESSAGE);
        return Validator.validateCycle(Console.readLine());
    }

    public static void printRacer(RacingCar racingCar) {
        System.out.println(racingCar.toString());
    }

    public static void printRacer(String winner) {
        System.out.println(WINNER_MESSAGE + winner);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResult() {
        System.out.println(PROCESS_RESULT_MESSAGE);
    }

}