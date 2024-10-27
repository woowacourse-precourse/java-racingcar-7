package racingcar.service;

import java.util.List;
import racingcar.dto.RacingCar;

public class OutputServiceImpl implements OutputService {
    private final StringBuffer sb;
    private final static OutputService outputServiceInstance = new OutputServiceImpl();

    private OutputServiceImpl() {
        sb = new StringBuffer();
    }

    public static OutputService getInstance() {
        return outputServiceInstance;
    }

    @Override
    public void notYetFinish(List<RacingCar> rcList) {
        for (RacingCar rc : rcList) {
            sb.append(
                    String.format(
                            "%s : %s", rc.getName(),
                            "-".repeat(rc.getMove())
                    )
            ).append("\n");
        }
    }

    @Override
    public void finish(List<RacingCar> rcList) {
        String[] winner = rcList.stream().
                filter(car -> car.getMove() == findMaxMove(rcList))
                .map(RacingCar::getName)
                .toArray(String[]::new);

        sb.append("최종 우승자 : ").append(String.join(", ", winner));
        System.out.println(sb);
    }

    private int findMaxMove(List<RacingCar> rcList) {
        return rcList.stream()
                .mapToInt(RacingCar::getMove)
                .max()
                .orElse(0);
    }
}
