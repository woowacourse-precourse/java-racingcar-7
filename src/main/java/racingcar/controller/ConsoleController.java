package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.util.StringUtil;
import racingcar.config.FilterConfig;
import racingcar.domain.CarDomain;
import racingcar.view.OutputView;
import racingcar.view.impl.ConsoleOutputView;

public class ConsoleController {

    private final OutputView outputView = new ConsoleOutputView();
    private final FilterConfig filterConfig = new FilterConfig();

    public List<CarDomain> getCarNameRequest() {
        outputView.displayCarNameRequest();
        String inputCarNames = Console.readLine();
        filterConfig.getCarNameFilterChain().doFilter(inputCarNames);
        return StringUtil.splitStringToList(inputCarNames).parallelStream()
                .map(name -> CarDomain.create(name, 0))
                .toList();
    }

    public String getRoundRequest() {
        return "";
    }
}
