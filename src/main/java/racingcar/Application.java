package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //1. 경주할 자동차의 이름을 쉼표 기준으로 구분하여 한줄에 받기
        String inputCar;
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            inputCar = Console.readLine();
        } catch (IllegalArgumentException e){
            return;
        }




    }
}
