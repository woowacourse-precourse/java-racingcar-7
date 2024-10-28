package racingcar.filter.impl.filter;

import racingcar.common.constant.ExceptionMessage;
import racingcar.common.exception.RoundValueException;
import racingcar.filter.Filter;
import racingcar.filter.FilterChain;

public class RoundInputPositiveIntegerFilter implements Filter {
    @Override
    public void doFilter(String input, FilterChain filterChain) {
        int round = Integer.parseInt(input);
        if (round < 0) {
            throw new RoundValueException(ExceptionMessage.ROUND_VALUE_NOT_POSITIVE);
        }
        filterChain.doFilter(input);
    }
}
