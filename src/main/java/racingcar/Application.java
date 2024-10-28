package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //1. 경주할 자동차의 이름을 쉼표 기준으로 구분하여 한줄에 받기
        String inputCar;

        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            inputCar = Console.readLine();
            String car = inputCar;
            String[] carArr = car.split(",");

            //1-1. 자동차 이름이 5자를 초과한 경우 에러 출력
            for (String checkCar : carArr) {
                if (checkCar.length()>5){
                    throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
                }
            }

        } catch (IllegalArgumentException e){
            return;
        }

        //feat:2. 시도할 횟수 변수에 횟수 값 입력 받기

        String inputTry;
        System.out.println("시도할 횟수는 몇 회인가요?");
        inputTry = Console.readLine();



    }
}
