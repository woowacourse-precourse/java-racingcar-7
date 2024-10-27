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
        validateTotalTryCnt(totalTryCnt);

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

    private Boolean validateTotalTryCnt(String totalTryCnt){
        Long tmpValue;

        try {
            tmpValue = Long.parseLong(totalTryCnt);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorCode.CNT_FORMAT_ERROR.getMessage());
        }

        if (tmpValue <= 0) {
            throw new IllegalArgumentException(ErrorCode.CNT_RANGE_ERROR.getMessage());
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
