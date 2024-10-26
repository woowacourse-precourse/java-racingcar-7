# java-racingcar-precourse
___

## 협력
___
- 숫자를 통해 우열을 가리는 게임
  - 반드시 무작위 숫자를 통한 게임일 것
  - 반드시 유저명을 기입할 수 있을 것

### domain
___
- [ ] `interface Moveable`
  - [ ] `isSatisfiedBy(Rule rule)`
    - [ ] `class DistanceMove implements Moveable`


- [ ] `interface Roundable`
  - [ ] `isSatisfiedBy(Rule rule);`
    - [ ] `class RoundNumber implements Roundable`


- [ ] `abstract class RacingMachine`
  - [ ] `Name name`
    - [ ] `MoveAmount number`


- [ ] `interface Name`
  - [ ] `isSatisfiedBy(Rule rule)`
    - [ ] `class MachineName implements Name`


- [ ] `class RuleManager`
  - [ ] `RuleManager()`
    - [ ] `rule = woowaracingrule`


[//]: # (- [ ] `interface Rule`)

[//]: # (  - [ ] )

[//]: # (  - )

[//]: # (    - `WoowaRacingRule`)

[//]: # (      - [ ] `MAXIMUM_NAME_LENGTH`)

[//]: # (      - [ ] `CUTOFF`)

[//]: # (        - [ ] `isAbove`)

## 확장
___
- Rule
  - 규칙 자체가 바뀌는 경우
  - 값이 바뀌는 경우

- RacingMachine
  - 값이 추가된 다양한 구현체

## 구현
___