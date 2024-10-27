package racingcar.view;

import java.util.List;
import racingcar.dto.RaceResponse;

public class RaceView implements View {

    private RaceResponse raceResponse;

    public RaceView(RaceResponse raceResponse) {
        this.raceResponse = raceResponse;
    }

    public static View createView(RaceResponse raceResponse) {
        return new RaceView(raceResponse);
    }

    @Override
    public void draw() {
        List<String> winners = raceResponse.getWinningCars();
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
