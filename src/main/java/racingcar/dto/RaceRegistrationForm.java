package racingcar.dto;

import java.util.List;

public record RaceRegistrationForm(List<String> carNames, int raceRoundCount) {

}
