package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CarRace {
    private final StringBuilder sb = new StringBuilder();
    private final Map<String, Car> carRaceList;
    private final Long roundNumber;

    public CarRace() {
        InputView inputView = new InputView();
        carRaceList = inputView.getCarList();
        roundNumber = inputView.getRoundNumber();
    }

    public void run() {
        carRace();
        List<String> winnerList = getWinnerList(getMaxDistance());
        print(winnerList);
    }

    protected void carRace() {
        sb.append("\n").append("실행결과").append("\n");

        for (long i = 0; i < roundNumber; i++) {
            carRaceList.forEach((name, car) -> {
                car.moveOrNot();
                sb.append(car);
            });
            sb.append("\n");
        }
    }

    private List<String> getWinnerList(Long maxDistance) {
        List<String> winnerList = new ArrayList<>();

        carRaceList.forEach((name, car) -> {
            if (Objects.equals(car.getDistance(), maxDistance)) {
                winnerList.add(name);
            }
        });

        return winnerList;
    }

    private Long getMaxDistance() {
        return Collections.max(carRaceList.values(), new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Long.compare(o1.getDistance(), o2.getDistance());
            }
        }).getDistance();
    }

    protected void print(List<String> winnerList) {
        sb.append("최종 우승자 : ");
        for (String name : winnerList) {
            sb.append(name).append(" ,");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString().trim());
    }
}
