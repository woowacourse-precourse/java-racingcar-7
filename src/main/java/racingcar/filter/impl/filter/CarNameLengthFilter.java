package racingcar.filter.impl.filter;

import static racingcar.common.constant.Constant.*;

import java.util.List;
import racingcar.common.constant.ExceptionMessage;
import racingcar.common.exception.CarNameException;
import racingcar.common.util.StringUtil;
import racingcar.filter.Filter;
import racingcar.filter.FilterChain;

public class CarNameLengthFilter implements Filter {

    @Override
    public void doFilter(String input, FilterChain filterChain) {
        List<String> names = StringUtil.splitStringToList(input);
        names.parallelStream()
                .filter(name -> name.length() > MAX_CAR_NAME_LENGTH)
                .findAny()
                .ifPresent(name -> {
                    throw new CarNameException(ExceptionMessage.CAR_NAME_TOO_LONG);
                });
        filterChain.doFilter(input);
    }
}
