package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.dto.request.RacingCarRequest;
import racingcar.util.CustomStringUtils;
import racingcar.util.StringValidator;

import java.util.*;

public class RacingCarService {
    public List<String> playRacingCar(RacingCarRequest request) {
        List<RacingCar> carList = makeCarList(request.carNames());
        int tryCount = request.tryCount();

        while(tryCount-- > 0) {
            playRacingCar(carList);
        }

        return getWinners(carList);
    }

    private List<RacingCar> makeCarList(String carNames) {
        StringTokenizer st = new StringTokenizer(carNames, ",");

        List<RacingCar> carList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String carName = st.nextToken().trim();

            if (!StringValidator.validateLength(carName)) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
            }

            if (!StringValidator.validateName(carName, carList)) {
                throw new IllegalArgumentException("같은 사용자입니다.");
            }

            carList.add(new RacingCar(carName, 0));
        }

        return carList;
    }

    private void playRacingCar(List<RacingCar> carList) {
        for (RacingCar car : carList) {
            car.move();
        }

        CustomStringUtils.printRoundStatus(carList);
    }

    private List<String> getWinners(List<RacingCar> carList) {
        int maxPosition = carList.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .toList();
    }
}