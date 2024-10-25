package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        CarNameHandler carNameHandler = new CarNameHandler();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        MovementHandler movementHandler = new MovementHandler();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String movement = Console.readLine();
        int movementNumber = movementHandler.storeMovement(movement);


        // 차 이름 저장
        CarData carData = carNameHandler.storeCar(carNamesInput);

        // 결과 출력
        System.out.println("입력된 차 이름: " + carData.getCarNames());
    }


}
