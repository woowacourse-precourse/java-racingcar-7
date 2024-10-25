package racingcar.domain;

import racingcar.validation.Validation;

import java.util.List;
import java.util.stream.Collectors;

public class Racingcars {
    private List<Racingcar> racingcars;

    public Racingcars(List<String> racingcarNames) {
        Validation.validateRacingcarNamesDuplicate(racingcarNames);
        this.racingcars = createRacingcars(racingcarNames);
    }

    public List<Racingcar> getRacingcars(){
        return racingcars;
    }

    private List<Racingcar> createRacingcars(List<String> racingcarNames){
        return racingcarNames.stream()
                .map(Racingcar::new)
                .collect(Collectors.toList());
    }
}
