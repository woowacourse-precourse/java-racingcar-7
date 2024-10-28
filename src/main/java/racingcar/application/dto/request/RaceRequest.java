package racingcar.application.dto.request;

import racingcar.domain.race.vo.Round;

public record RaceRequest(String carNames, Round round) {

}
