package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record InputDTO( List<Car> cars, int tryCnt ) {}
