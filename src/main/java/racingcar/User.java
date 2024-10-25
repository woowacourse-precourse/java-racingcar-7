package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static String getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        isCorrectSeparator(Console.readLine());
        isLastStringComma(Console.readLine());
        return Console.readLine();
    }

    public static int getTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNumber;
        tryNumber = isTryNumberDigit();
        return tryNumber;
    }

    public static String[] getCars(){
        String carNames = getCarNames();
        String[] cars = carNames.split(",");
        isEmpty(cars);
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

    public static int isDigit(String inputNumber){
        int tryNumber = Integer.parseInt(inputNumber);
        return tryNumber;
    }

    public static int isTryNumberDigit() {
        int tryNumber;
        try {
            tryNumber = isDigit(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }
        return tryNumber;
    }

    public static void isEmpty(String[] cars){
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].isEmpty()){
                throw new IllegalArgumentException("자동차 이름을 정확히 입력해주세요.");
            }
        }
    }
}
