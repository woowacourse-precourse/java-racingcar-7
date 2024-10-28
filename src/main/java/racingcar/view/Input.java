package racingcar.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분";
    private static final String INPUT_GAME_NUMBER = "시도할 횟수는 몇 회인가요?";

    public static List<String> inputCarName() throws IllegalArgumentException{
        System.out.println(INPUT_CAR_NAME);
        List<String> nameOfCars = Arrays.stream(readLine()
                        .split(","))
                .toList();
        if(nameOfCars.size() == 0){
            throw new IllegalArgumentException("자동차 입력이 올바르지 않습니다.");
        }

        for(String nameOfCar: nameOfCars){
           if(!isNameShorterThan5(nameOfCar)){
               throw new IllegalArgumentException("자동차의 이름은 다섯 글자 이하여야 합니다.");
           }
        }

        return nameOfCars;
    }

    public static int inputGameNumber(){
        System.out.println(INPUT_GAME_NUMBER);
        String numberOfGames = readLine();
        if(!isInteger(numberOfGames)){
            throw new IllegalArgumentException("정수만 입력하여야 합니다.");
        }
        return Integer.parseInt(numberOfGames);
    }

    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isNameShorterThan5(String carName){
        if(carName.length() > 5){
            return false;
        }
        return true;
    }
}
