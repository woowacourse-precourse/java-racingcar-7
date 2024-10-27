package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = readLine();
        String[] carNames = carNameInput.split(",");
        Car[] cars = createCars(carNames);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(readLine());
        PlayGame play=new PlayGame();
        System.out.println("실행 결과");
        for (int i=0;i<count;i++){
            play.setTryNumber(cars,count);
            play.printAdvanceArrays(cars);
            System.out.println();
        }
    }

    public static Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        validateCarNames(carNames); // 자동차 이름 유효성 검사
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
