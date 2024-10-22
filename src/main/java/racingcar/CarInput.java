package racingcar;

import java.util.Scanner;

public class CarInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = scanner.nextLine();
        String[] carNames = input.split(",");

        validateCarNames(carNames);

        return carNames;
    }

    private static void validateCarNames(String[] carNames){
        for(String name : carNames){
            if(name.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다: " + name);
            }
        }
    }
}