package racingcar.dto;

import java.util.List;

public record GetWinnersResponse(
        List<String> winnersName
) {
}