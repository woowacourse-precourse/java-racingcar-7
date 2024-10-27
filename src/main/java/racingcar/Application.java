package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Input.readCarNames();

        Racing racing = new Racing();
        List<Car> carList = racing.settingCar(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfMoves = Input.readNumberOfMoves();

        System.out.println();
        System.out.println("실행 결과");

        racing.start(carList, numberOfMoves);

        int maxLocation = racing.getWinnerLocation(carList);

        List<String> winners = racing.getCarNamesAtLocation(carList, maxLocation);

        String result = String.join(",", winners);

        System.out.println("최종 우승자 : " + result);
    }
}
