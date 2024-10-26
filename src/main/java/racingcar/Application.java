package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static List<String> carNames = new ArrayList<>();
    private static Integer round;
    public static void main(String[] args) {
        readUserInput();
    }

    private static void readUserInput(){
        String input = Console.readLine();

        carNames.addAll(Arrays.asList(input.split(",")));

        for(String name: carNames){
            if(name.length() > 5) throw new IllegalArgumentException("자동차 이름의 길이가 5 초과 입니다.");
        }

        input = Console.readLine();
        round = Integer.parseInt(input);
        Console.close();
    }
}
