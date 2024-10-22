package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    // TODO: 사용자가 잘못된 값을 입력했을 때 상황들 생각해보기
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int repeatCount = Integer.parseInt(Console.readLine());

        List<Car> carList = new ArrayList<>();
        for (final String carName : carNames.split(",")) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            carList.add(new Car(carName));
        }

        System.out.println("실행 결과");
        String winners = "";
        while(repeatCount > 0) {
            for(final Car car : carList) {
                car.go();
                System.out.println(car.getName() + ": " + car.getLocation());

                if(car.getLocation().equals("-----")) {
                    winners += car.getName();
                    repeatCount = 0;
                }
            }

            System.out.println();
            repeatCount--;
        }

        System.out.println("최종 우승자: " + winners);
    }

}

