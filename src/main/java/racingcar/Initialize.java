package racingcar;

public class Initialize {
    public static Car[] initializeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = camp.nextstep.edu.missionutils.Console.readLine().split(",");
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i].trim());
        }

        return cars;
    }

    public static int initializeAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
    }
}
