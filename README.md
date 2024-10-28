# java-racingcar-precourse

## 1. 기능요구사항 정리

### 1.1) 입력요구 사항 정리

- 첫번 째 입력에는 자동차의 이름을 입력한다. 조건은 다음과 같다.
  - 자동차의 이름은 쉼표(`","`)로 구분한다.
  - 하나의 이름은 1글자이상 5글자 이하이다.
  - 이름에는 숫자, 알파벳, 한글의 조합만 허용된다.
  - 쉼표를 기준으로 2개 이상 입력을 해야 한다.
  - 최대 자동차 수는 20이다. 즉, 쉼표를 기준으로 최대 20개의 자동차 이름을 적을 수 있다.
- 두번 째 입력에는 경주를 시도할 횟수를 입력한다.
  - 시도할 횟수는 1이상 이다.
  - 컴퓨터가 과부화될 것을 고려하여 최대 값은 99999로 제한한다.(나중에 수정가능)
- 예외사항: 위의 조건에 위배되는 사항들은 모두 IllegalArgumentException 발생 시키며 케이스마다 다음의 에러메시지를 작성한다.
  - 첫번 째 입력 케이스
    - abc,abc -> `"생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다."`(중복된 이름)
    - abc -> `"생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다."`
    - "" -> `"생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다."`
    - abcdef -> `"생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다."`
    - abc,abcdefg -> `"이름은 1글자 이상, 5글자 이하 입니다."`
    - abc,   abc -> `이름은 숫자, 알파벳, 한글 조합만 가능합니다.`(공백 안됨)
    - ###!1,23@/n -> `"이름은 숫자, 알파벳, 한글 조합만 가능합니다."`
    
  - 두번 째 입력 케이스
    - 0 -> `"시도할 횟수는 1이상 99999이하입니다."`
    - 99999999 -> `"시도할 횟수는 1이상 99999이하 입니다."`
    - "abc" -> `"숫자를 입력해주세요."`

<br>

### 1.2) 게임 진행 요구사항

- 게임은 시도할 횟수 n만큼 진행한다.
- n번 동안 각 자동차는 멈추거나 앞으로 한칸 전진한다.
- 각 자동차마다 무작위 숫자를 구하고, 숫자가 4 이상일 경우에만 전진한다.
- 게임이 끝나고 제일 많이 전진한 자동차가 우승한다. 우승자는 1명 이상일 수 있다.

<br>

### 1.3) 출력 요구사항 

- 각 게임 진행마다 모든 참가자(자동차 이름)를 세로로 출력한다.
- 각 게임은 한 칸의 공백을 두어 구분한다.
- 각 게임 진행마다 전진하는 자동차는 `"-"`를 추가한다.
- 최종 우승자를 마지막에 출력한다. 두 명 이상일 경우에는 쉼표(`","`)로 구분한다.

<br>

### 1.4) 입출력, 게임 진행 상황 예시

```shell
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

<br>

#### 진행상황 체크박스
- [x] 입력 요구사항
	- [x] 자동차 이름 검증 구현
	- [x] 시도할 횟수 검증 구현
	- [x] InputView 구현
- [x] 게임 진행 요구사항
	- [x] 랜덤 숫자에 따라 움직임 여부 구현
	- [x] 게임 회차마다 진행상황 기록 구현
	- [x] 우승자 get 구현
	- [x] 게임 실행 구현  
- [x] 출력 요구사항
	- [x] 실행 결과 출력 구현
	- [x] 최종 우승자 출력 구현
