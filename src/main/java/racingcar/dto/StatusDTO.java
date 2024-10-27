package racingcar.dto;

import java.util.*;

public record StatusDTO( Map<String, Integer> status ) {

    /**
     * 현재상태에서 1등에 대한 정보를 가져옵니다
     * @return 1등의 이름을 담은 List
     */
    public ResultDTO getFirstPlace() {
        Map<String, Integer> status = this.status();
        List<String> names = new ArrayList<>( status.size() );
        int max_dist = -1;
        for ( String key: status.keySet() ) {
            Integer value = status.get(key);
            if ( value.compareTo( max_dist ) < 0 ) continue;
            if ( value.compareTo( max_dist ) > 0 ) {
                max_dist = value;
                names.clear();
            }
            names.add( key );
        }

        return new ResultDTO( names );
    }
}