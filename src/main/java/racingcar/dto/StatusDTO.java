package racingcar.dto;

import java.util.*;

public record StatusDTO( Map<String, Integer> status ) {
    public ResultDTO getFirstPlace() {
        return new ResultDTO( new ArrayList<String>( 10 ) );
    }
}