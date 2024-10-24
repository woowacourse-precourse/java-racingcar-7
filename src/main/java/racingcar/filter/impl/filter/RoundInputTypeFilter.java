package racingcar.filter.impl.filter;

import racingcar.common.constant.ExceptionMessage;
import racingcar.common.exception.RoundValueException;
import racingcar.filter.Filter;
import racingcar.filter.FilterChain;

public class RoundInputTypeFilter implements Filter {
    @Override
    public void doFilter(String input, FilterChain filterChain) {
        try {
            Integer.valueOf(input);
            filterChain.doFilter(input);
        } catch (NumberFormatException e) {
            throw new RoundValueException(ExceptionMessage.ROUND_VALUE_NOT_INTEGER);
        }
    }
}
