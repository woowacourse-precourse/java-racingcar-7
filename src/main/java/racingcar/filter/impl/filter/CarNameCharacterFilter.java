package racingcar.filter.impl.filter;

import java.util.List;
import racingcar.common.constant.ExceptionMessage;
import racingcar.common.exception.CarNameException;
import racingcar.common.util.StringUtil;
import racingcar.filter.Filter;
import racingcar.filter.FilterChain;

public class CarNameCharacterFilter implements Filter {
    @Override
    public void doFilter(String input, FilterChain filterChain) {
        List<String> names = StringUtil.splitStringToList(input);
        names.parallelStream()
                .filter(name -> !name.matches("^[a-zA-Z0-9가-힣]+$"))
                .findAny()
                .ifPresent(name -> {
                    throw new CarNameException(ExceptionMessage.INVALID_CAR_NAME_CHARACTERS);
                });
        filterChain.doFilter(input);
    }
}
