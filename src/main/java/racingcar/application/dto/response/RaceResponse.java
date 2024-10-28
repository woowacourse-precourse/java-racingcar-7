package racingcar.application.dto.response;

import racingcar.domain.race.vo.RaceResult;
import racingcar.domain.race.vo.Winners;

public record RaceResponse(RaceResult raceResult, Winners winners) implements Response {

}
