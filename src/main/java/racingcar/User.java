package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static String getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        isCorrectSeparator(Console.readLine());
        isLastStringComma(Console.readLine());
        return Console.readLine();
    }

    public static int getTryNumber(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNumber = Integer.parseInt(Console.readLine());
        return tryNumber;
    }

    public static String[] getCars(){
        String carNames = getCarNames();
        String[] cars = carNames.split(",");
        return cars;
    }

    public static void isCorrectSeparator(String carNames){
        if(!carNames.contains(",")){
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    public static void isLastStringComma(String carNames){
        if(carNames.endsWith(",")){
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }
}
