package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String[] readCarNames(){
        String input = Console.readLine();

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

    public static int readNumberOfMoves(){
        return Integer.parseInt(Console.readLine());
    }
}
