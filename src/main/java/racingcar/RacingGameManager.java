package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class RacingGameManager implements RacingGame {
    private final List<Car> racingCarsList = new ArrayList<>();

    @Override
    public void ready(List<String> cars) {
        for (String car : cars) {
            InputValidator.nameValidation(car);

            this.racingCarsList.add(Car.create(car));
        }
    }

    @Override
    public void start(int tryNumber) {
        InputValidator.tryNumberValidation(tryNumber);

        for (int i = 0; i < tryNumber; i++) {
            progressGame();
        }

        endGame();
    }

    private void progressGame() {
        for (Car car : racingCarsList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.movingForward();
            } else {
                car.stop();
            }
        }
        System.out.println();
    }

    private void endGame() {
        findWinners();
        announceWinners();
    }

    private List<String> findWinners() {
        int maxForwardNumber = 0;
        List<String> winnerList = new ArrayList<>();

        //가장 높은 전진횟수 찾기 -> 우승자의 조건
        for (Car value : racingCarsList) {
            int forwardNumber = value.getForwardNumber();
            if (maxForwardNumber < forwardNumber) {
                maxForwardNumber = forwardNumber;
            }
        }
        //가장 높은 전진 횟수에 해당하는 참여자 찾기 -> 우승자들
        for (Car car : racingCarsList) {
            if (maxForwardNumber == car.getForwardNumber()) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private void announceWinners() {
        List<String> finalWinners = findWinners();
        System.out.println("최종 우승자 : " + String.join(", ", finalWinners));
    }
}
