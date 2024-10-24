package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int N = Integer.parseInt(Console.readLine());


        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();
        for(String name : carNames)
        {
            Car car = new Car(name.trim() , 0);
            cars.add(car);
        }


        Game controllGame = new Game(cars,N);
        for(int i = 0; i < controllGame.getTrial(); i++)
        {
            for(Car car : controllGame.getCarList())
            {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if(randomNumber >= 4) {
                    car.setStep(car.getStep() + 1);
                }
                car.printStatus();
            }
            System.out.println();
        }


        List<String> result = controllGame.returnMax();
        if (result.size() == 1) {
            System.out.printf("최종 우승자 : %s%n", result.get(0));
        } else {
            System.out.printf("최종 우승자 : %s%n", String.join(", ", result));
        }


    }
}
