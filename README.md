# java-racingcar-precourse

****
> ## 기능 목록
> 1. `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하여 사용자의 입력 값을 받는다.
>    1. 사용자의 입력 값은 경주할 자동차명과 총 이동 횟수이다.
>    2. 자동차명은 쉼표(`,`)로 구분되며, 이름은 5자 이하만 가능하다.
>    3. 총 이동 횟수는 숫자이지만 readLine()으로 입력받으면 문자열로 처리되므로, Integer.parseInt()를 사용하여 추가적인 타입 변환 작업이 필요하다.
>    4. 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다. (예외 처리는 기능 구현 후, 별도로 처리한다.)
>
>
> 2. 프로그램의 메인 로직 구현은 별도의 클래스(`CarRace`)에서 진행한다.
>    1. `start(String cars, int moveAttempts)` : 자동차 경주를 진행하는 메서드
>    2. `printFinalWinnner()` : 최종 우승자를 출력하는 메서드
>
>
> 3. `split()` 메서드를 사용해 경주할 자동차 이름을 분리한다.
>    1. 이때, 사용자의 입력값에 공백이 포함될 수 있으므로, `strip()` 메서드를 사용해 자동차 이름의 불필요한 공백을 제거한다.
>
>
> 4. 자동차가 전진하는 조건은 다음과 같다:
>   > _**0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우**_
>    1. Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
>    2. 사용자가 입력한 총 이동 횟수만큼 무작위 값을 반복해서 추출한다.
>    3. 매 이동마다 실행 결과를 다음과 같이 출력한다.
>
>   >    실행 결과   
>    pobi : -  
>    woni :  
>    jun : -
>
>
> 5. 자동차 경주 게임을 완료한 후 우승자를 발표한다. 우승자는 한 명 이상일 수 있으며, 여러 명일 경우 쉼표(,)로 구분하여 표시한다.
>    - 단독 우승자 안내 문구
>    > 최종 우승자 : pobi
>    - 공동 우승자 안내 문구
>    >    최종 우승자 : pobi, jun

> ## 예외 처리
>
> 1. 입력된 자동차 이름을 split() 메서드를 사용해 배열에 저장한다. 이때, 각 자동차 이름의 길이가 5자를 초과하면 IllegalArgumentException을 발생시킨다.
>
>
> 2. 쉼표를 구분자로 사용하지 않았을 경우, `IllegalArgumentException`을 발생시킨다.
>
>
> 3. 총 이동 횟수를 입력받고 `int`형으로 변환할 때, 입력 값이 숫자로 변환할 수 없는 경우 `IllegalArgumentException`을 발생시킨다.
>
>
> 4. 자동차명에 공백, 빈 문자열, 또는 null 값이 포함될 경우, IllegalArgumentException을 발생시킨다.
