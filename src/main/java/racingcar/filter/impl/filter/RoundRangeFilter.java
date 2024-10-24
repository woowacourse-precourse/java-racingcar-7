package racingcar.filter.impl.filter;

import racingcar.common.constant.ExceptionMessage;
import racingcar.common.exception.RoundValueException;
import racingcar.filter.Filter;
import racingcar.filter.FilterChain;

public class RoundRangeFilter implements Filter {
    @Override
    public void doFilter(String input, FilterChain filterChain) {
        int round = Integer.parseInt(input);
        if (round <= 0 || round > Integer.MAX_VALUE) {
            throw new RoundValueException(ExceptionMessage.ROUND_VALUE_OUT_OF_RANGE);
        }
        filterChain.doFilter(input);
    }
}
