# java-racingcar-precourse

### 요구 사항
- 입력
    - [ ] 중복 없이 5글자 이내의 자동차 이름을 ,로 구분되게 입력받는다. (최대 5대)
    - [ ] 시도 횟수를 입력받는다. (최대 10회)
    - [ ] 입력이 잘못된 경우, IllegalArgumentException를 발생시킨 후 종료한다.
- 진행
    - [ ] 각 회차마다 0에서 9 사이의 무작위 값을 생성한다.
    - [ ] 무작위 값이 4이상일 때 해당 자동차를 전진한다.
- 출력
    - [ ] 각 회차마다 전진하는 자동차를 이름과 함께 출력한다.
    - [ ] 최종 우승자를 ,로 구분하며 출력한다.
- 라이브러리
    - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

### 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```