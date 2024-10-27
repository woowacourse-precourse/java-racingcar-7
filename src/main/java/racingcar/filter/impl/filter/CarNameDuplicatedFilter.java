package racingcar.filter.impl.filter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.common.constant.ExceptionMessage;
import racingcar.common.exception.CarNameException;
import racingcar.common.util.StringUtil;
import racingcar.filter.Filter;
import racingcar.filter.FilterChain;

public class CarNameDuplicatedFilter implements Filter {
    @Override
    public void doFilter(String input, FilterChain filterChain) {
        List<String> names = StringUtil.splitStringToList(input);
        Set<String> nameSet = new HashSet<>();
        names.stream().filter(name -> !nameSet.add(name)).forEach(name -> {
            throw new CarNameException(ExceptionMessage.CAR_NAME_DUPLICATED);
        });
    }
}
