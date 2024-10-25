package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.RacingCar;
import racingcar.dto.request.RacingCarRequest;

public class RacingCarService {

    public List<String> playRacingCar(RacingCarRequest request) {
        List<RacingCar> carList = makeCarList(request.carNames());
        int tryCount = request.tryCount();

        return null;
    }

    private List<RacingCar> makeCarList(String carNames) {
        StringTokenizer st = new StringTokenizer(carNames, ",");

        List<RacingCar> carList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String carName = st.nextToken();

            carList.add(new RacingCar.Builder()
                    .name(carName)
                    .position(0)
                    .build());
        }

        return carList;
    }

    private void playRacingCar(List<String> carNameList, int tryCount) {

    }
}
