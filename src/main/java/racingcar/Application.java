package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int MAX_NAMES_COUNT = 25;
    private static final int MIN_COUNT = 1;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            startGame();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void startGame()  {
        printStartMessage();
        String input = getCarNamesInput().replaceAll(" ","");
        validateEmptyInput(input);
        String[] names = splitWithComma(input);
        validateNamesCount(names);
    }

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTryCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static String getCarNamesInput() {
        return Console.readLine();
    }

    public static void validateEmptyInput(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("정확한 값을 입력해 주세요.");
        }
    }

    public static String[] splitWithComma(String input) {
        return input.split(",");
    }

    public static void validateNamesCount(String[] names) {
        if(names.length > MAX_NAMES_COUNT || names.length < MIN_COUNT) {
            throw new IllegalArgumentException("가능한 자동차 수는 최소 1대, 최대 25대입니다.");
        }
    }
}
