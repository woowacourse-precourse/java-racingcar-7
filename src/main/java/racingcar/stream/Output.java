package racingcar.stream;

import racingcar.domain.RacingCar;

import java.util.List;

public interface Output {
    void writeCarNameGuide();

    void writeRoundCountGuide();

    void writeWhiteLine();

    void writeResultTitle();

    void writeWinners(List<String> winners);

    void outputRoundResult(List<RacingCar> racingCarList);
}
