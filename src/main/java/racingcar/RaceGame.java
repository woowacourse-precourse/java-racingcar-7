package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;


public class RaceGame {

    List<Car> carList = new ArrayList<>();
    int roundCount = 0;

    void start() {
        inputCarNames();
        inputRoundCount();
        System.out.println("실행 결과");
        int currentRound = 0;
        while(currentRound < roundCount) {
            startRound();
            currentRound++;
        }

        List<String> winner = getWinner();
        System.out.println("최종 우승자 : " + String.join(",", winner));
    }

    void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputText = Console.readLine();
        String[] carNames = inputText.split(",");
        for(String carName : carNames) {
            // 자동차 이름이 비어있거나, 이름이 5자를 초과할 경우 예외 처리
            if(carName.isEmpty() || carName.length() > 5) {
                throw new RuntimeException();
            }
            carList.add(new Car(carName));
        }
    }

    void inputRoundCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int inputCount = Integer.parseInt(Console.readLine());
        if(inputCount < 1) {
            throw new RuntimeException();
        }
        this.roundCount = inputCount;
    }

    void startRound() {
        for(Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if(randomNumber > 3) {
                car.forward();
            }
            System.out.println(car.getName() + " : " + "-".repeat(car.getForwardCount()));
        }
        System.out.println();
    }

    List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxForwardCount = Integer.MIN_VALUE;

        for(Car car : carList) {
            if(car.getForwardCount() > maxForwardCount) {
                winners.clear();
                winners.add(car.getName());
                maxForwardCount = car.getForwardCount();
            } else if(car.getForwardCount() == maxForwardCount) {
                winners.add(car.getName());
            }
        }

        return winners;
    }


}