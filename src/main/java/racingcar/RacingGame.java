package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    private final List<RacingCar> cars = new ArrayList<>();
    private final int round;

    public RacingGame(List<String> carNames, int round) {
        this.round = round;
        createCar(carNames);
    }

    private void createCar(List<String> carNames) {
        for(String carName : carNames) {
            cars.add(new RacingCar(carName));
        }
    }

    public void startGame() {
        for (int i = 0; i < round; i++) {
            playRound();
            printRoundResult();
        }
        printGameResult();
    }

    public void playRound() {
        for (RacingCar car : cars) {
            if(Randoms.pickNumberInRange(0,9) >= 4) {
                car.forward();
            } else {
                car.stop();
            }
        }
    }

    public void printRoundResult() {
        System.out.println("실행 결과");
        for (RacingCar car : cars) {
            System.out.print(car.carName + " : ");
            System.out.print("-".repeat(car.currentPosition));
            System.out.println();
        }
    }

    public void printGameResult() {
        List<CarDTO> winners = findWinners(); // 최종 우승자 찾기
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getCarName()); // 우승자 이름 출력
            if (i < winners.size() - 1) {
                System.out.print(", "); // 마지막 우승자가 아닐 경우 콤마 추가
            }
        }
        System.out.println(); // 줄바꿈
    }

    public List<CarDTO> findWinners() {
        List<CarDTO> winners = new ArrayList<>();
        Car leadingCar = cars.getFirst();

        for (Car car : cars) {
            if (car.isAheadOf(leadingCar)) {
                leadingCar = car;
                winners.clear();
                winners.add(car.toDTO());
            } else if (car.isAtSamePosition(leadingCar)) {
                winners.add(car.toDTO());
            }
        }

        return winners;
    }

}
