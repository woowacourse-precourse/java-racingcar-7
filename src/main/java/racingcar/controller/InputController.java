package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.util.StringUtil;
import racingcar.config.FilterConfig;
import racingcar.domain.CarDomain;
import racingcar.domain.CarDomains;
import racingcar.view.OutputView;
import racingcar.view.impl.ConsoleOutputView;

public class InputController {

    private final OutputView outputView = new ConsoleOutputView();
    private final FilterConfig filterConfig = new FilterConfig();

    public CarDomains getCarNameRequest() {
        System.out.println(outputView.displayCarNameRequest());
        String inputCarNames = Console.readLine();
        filterConfig.getCarNameFilterChain().doFilter(inputCarNames);
        return CarDomains.create(StringUtil.splitStringToList(inputCarNames).stream()
                .map(name -> CarDomain.create(name, 0))
                .toList());
    }

    public Integer getRoundRequest() {
        System.out.println(outputView.displayRoundRequest());
        String inputRound = Console.readLine();
        filterConfig.getRoundFilterChain().doFilter(inputRound);
        return Integer.valueOf(inputRound);
    }
}
