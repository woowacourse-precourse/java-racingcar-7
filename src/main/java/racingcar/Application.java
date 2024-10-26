package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    // TODO: 사용자가 잘못된 값을 입력했을 때 상황들 생각해보기
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int repeatCount = Integer.parseInt(Console.readLine());

        if(carNames.endsWith(",") || carNames.isEmpty() || repeatCount <= 0) {
            throw new IllegalArgumentException();
        }

        StringTokenizer st = new StringTokenizer(carNames, ",");
        List<Car> carList = new ArrayList<>();
        for (final String carName : carNames.split(",")) {
            if(carName.length() > 5 || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
            carList.add(new Car(carName));
        }

        System.out.println("실행 결과");
        int winnerLocation = 0;
        while(repeatCount > 0) {
            for(final Car car : carList) {
                car.go();
                winnerLocation = Math.max(winnerLocation, car.getLocation());
                System.out.println(car.getName() + " : " + car.getLocationToString());
            }

            System.out.println();
            repeatCount--;
        }

        StringBuilder winners = new StringBuilder();
        for(final Car car : carList) {
            if(winnerLocation == car.getLocation()) {
                winners.append(car.getName());
                winners.append(",");
            }
        }

        System.out.println("최종 우승자 : " + winners.substring(0, winners.length() - 1));
    }
}