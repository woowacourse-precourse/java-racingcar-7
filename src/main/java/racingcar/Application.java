package racingcar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    private static final String START_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static String getInput(){
        String inputString = Console.readLine();
        Console.close();
        return inputString;
    }

    private static ArrayList<String> splitCarNames(String input){
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        return carNames;
    }

    private static ArrayList<String> getCarNames(){
        String inputString = getInput();
        ArrayList<String> carNames = splitCarNames(inputString);
        return carNames;
    }

    public static void main(String[] args) {
        System.out.println(START_TEXT);
        getCarNames();
    }
}
