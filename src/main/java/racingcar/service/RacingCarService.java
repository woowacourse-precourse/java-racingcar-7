package racingcar.service;

import static racingcar.util.CustomStringUtils.printRoundStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.RacingCar;
import racingcar.dto.request.RacingCarRequest;
import racingcar.util.CustomValidator;

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
            String carName = st.nextToken();

            if (!CustomValidator.validateLength(carName)) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
            }

            if (!CustomValidator.validateDuplicate(carList, carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
            }

            carList.add(new RacingCar.Builder()
                    .name(carName)
                    .position(0)
                    .build());
        }

        return carList;
    }

    private void playRacingCar(List<RacingCar> carList) {
        for (RacingCar car : carList) {
            car.move();
        }

        printRoundStatus(carList);
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
