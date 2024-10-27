package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.io.Input;
import racingcar.io.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {
    private Input input;
    private Output output;

    public RacingManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public Car[] createRacingCars(String carNames) {
        String[] carName = carNames.split(",");
        Car[] cars = new Car[carName.length];

        for (int i = 0; i < carName.length; i++) {
            cars[i] = new Car(carName[i].trim());
        }

        return cars;
    }

    public void Racing() {
        String carNames = input.inputCarName();
        int numberOfRounds = Integer.parseInt(input.inputNumberOfRound());
        Car[] cars = createRacingCars(carNames);

        System.out.println("실행결과");

        for (int i = 0; i < numberOfRounds; i++) {
            playRound(cars);
            output.printRaceResult(cars);  // 라운드 결과 출력
        }

        List<String> winners = findWinners(cars);
        output.printWinner(winners);  // 우승자 출력
    }


    public void playRound(Car[] cars) {
        for(Car car : cars) {
            int random = randomNumber();

            if(random >= 4){
                car.moveForward();
            }
        }
    }


    public List<String> findWinners(Car[] cars){
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition(); // 가장 멀리 간 자동차의 위치 업데이트
            }
        }

        // 2. 우승자 리스트 생성
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName()); // 우승자의 이름 추가
            }
        }

        return winners;

    }

    public int randomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
