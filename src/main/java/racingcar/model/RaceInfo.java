package racingcar.model;

import racingcar.utils.ErrorCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RaceInfo {
    private final List<String> names;
    private final Long totalTryCnt;

    public RaceInfo(List<String> names, String totalTryCnt) {
        validateNames(names);

        this.names = names;
        this.totalTryCnt = Long.parseLong(totalTryCnt);
    }

    private Boolean validateNames(List<String> names){
        Set<String> uniqueNames = new HashSet<>();

        for (String name : names) {
            if (name.length() == 0)
                throw new IllegalArgumentException(ErrorCode.NAME_EMPTY_ERROR.getMessage());

            if(uniqueNames.contains(name))
                throw new IllegalArgumentException(ErrorCode.NAME_DUPLICATE_ERROR.getMessage());

            uniqueNames.add(name);
        }

        return Boolean.TRUE;
    }

    public List<String> getNames() {
        return names;
    }

    public Long getTotalTryCnt() {
        return totalTryCnt;
    }
}
