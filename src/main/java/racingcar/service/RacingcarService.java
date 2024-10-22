package racingcar.service;

import racingcar.domain.Racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingcarService {

    public List<Racingcar> createRacingcars(List<String> racingcarNames){
        return racingcarNames.stream()
                .map(Racingcar::new)
                .collect(Collectors.toList());
    }

}
