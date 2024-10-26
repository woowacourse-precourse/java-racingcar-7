package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String cars = getCarNames();
    }
    private static String getCarNames() {
        System.out.println("자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    private static void validation(String carName){
        if(carName.length()>5) throw new IllegalArgumentException();
    }
}
