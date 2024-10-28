package racingcar.dto;

import java.util.Collection;

public record OutputResponse(String resultMessage, Collection<String> winners) {

    public static OutputResponse of(String resultMessage, Collection<String> winners) {
        return new OutputResponse(resultMessage, winners);
    }
}
