package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarService {
    public void moveCars() {
        for (int j = 1; j <= CarRepository.carList.size(); j++) {
            int randomValue = pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                CarRepository.carList.get(j - 1).go();
            }
        }
    }

    public void printCarsStatus() {
        for (int j = 1; j <= CarRepository.carList.size(); j++) {
            CarRepository.carList.get(j - 1).printStatus();
            System.out.println();
        }
    }

    public List<String> findWinners() {
        List<String> winnerList = new ArrayList<>();
        int maxStatus = CarRepository.carList.stream()
                .mapToInt(Car::getRacingStatus)
                .max()
                .orElse(0);

        for (int i = 0; i < CarRepository.carList.size(); i++) {
            if (CarRepository.carList.get(i).getRacingStatus() == maxStatus) {
                winnerList.add(CarRepository.carList.get(i).getName());
            }
        }
        return winnerList;
    }
}
