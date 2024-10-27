package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String[] readCarNames() {
        String input = Console.readLine();
        return parseCarNames(input);
    }

    public static int readNumberOfMoves() {
        String input = Console.readLine();
        return parseNumberOfMoves(input);
    }

    static String[] parseCarNames(String input){
        String[] carNames = input.split(",");

        for(String carName : carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("차 이름이 너무 깁니다.");
            }
        }
        if(input.charAt(input.length() - 1) == ','){
            throw new IllegalArgumentException("쉼표는 구분자로만 사용해야 합니다.");
        }

        return carNames;
    }

    static int parseNumberOfMoves(String input){
        return Integer.parseInt(input);
    }
}
