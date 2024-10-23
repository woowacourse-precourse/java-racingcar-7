package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.RacingCarView;

public class Application {
    // 입력
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingCarView racingCarView = new RacingCarView();

        String carNameInput = racingCarView.getCarNameInput();
        Long tryCount = Long.parseLong(racingCarView.getTryCount());

        List<Car> cars = new ArrayList<>();

        for(String carName : carNameInput.split(",")) {
            cars.add(new Car(carName, 0));
        }

        // 게임 진행
        while(tryCount-- > 0){
            for(Car car : cars){
                int ramdomNumber = Randoms.pickNumberInRange(0, 9);

                System.out.print(car.getName() + " : ");

                if(ramdomNumber >= 4){      // 전진
                    car.go();
                }
                for(int i = 0; i < car.getPos(); i++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        // 게임 결과 산출
        int max = 0;
        for(Car car : cars){
            max = Math.max(max, car.getPos());
        }

        List<String> winnerList = new ArrayList<>();
        for(Car car : cars){
            if(car.getPos() == max){
                winnerList.add(car.getName());
            }
        }

        String result = String.join(", ", winnerList);

        racingCarView.printResult(result);
    }
}
