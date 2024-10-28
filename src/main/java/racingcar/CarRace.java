package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CarRace {
    private final InputView inputView = new InputView();
    private final StringBuilder sb = new StringBuilder();

    private final Map<String, Car> carMap;
    private final Long roundNumber;

    public CarRace() {
        carMap = inputView.getCarMap();
        roundNumber = inputView.getRoundNumber();
    }

    public void run() {
        performRace();
        printResult(getWinnerList());
    }

    protected void performRace() {
        sb.append("\n").append("실행결과").append("\n");

        for (long i = 0; i < roundNumber; i++) {
            carMap.forEach((name, car) -> {
                car.updateDistance();
                sb.append(car);
            });
            sb.append("\n");
        }
    }

    private List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        Long maxDistance = getMaxDistance();

        carMap.forEach((name, car) -> {
            if (Objects.equals(car.getDistance(), maxDistance)) {
                winnerList.add(name);
            }
        });

        return winnerList;
    }

    private Long getMaxDistance() {
        return Collections.max(carMap.values(), new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Long.compare(o1.getDistance(), o2.getDistance());
            }
        }).getDistance();
    }

    protected void printResult(List<String> winnerList) {
        sb.append("최종 우승자 : ");
        for (String name : winnerList) {
            sb.append(name).append(" ,");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString().trim());
    }
}
