# 자동차 경주 기능 목록


## 자동차 경주 게임에 대한 설명
n 대의 자동차를 서로 경주시키고, 우승자를 출력한다.

## 자동차 경주 게임의 흐름

입력 -> 게임 진행(차수별 진행 결과 출력) -> 우승자 출력

### 입력
- 경주할 자동차 이름 입력(이름은 쉼표(,) 기준으로 구분)
- 이동을 시도할 횟수 입력

### 게임 과정
- 각 자동차가 전진하는 조건: 0부터 9사이의 무작위 값을 생성하여 4이상이 나온 경우
- 각 자동차가 정지하는 조건: 0부터 9사이의 무작위 값을 생성하여 3이하가 나온 경우
- 입력한 `이동을 시도할 횟수`만큼 반복
- 경주 게임을 완료

### 출력
- 게임 과정: 차수별 실행 결과를 출력 (전진은 `-`로 표현)
- 게임 완료 후: 전진 횟수가 가장 많은 경우 우승자로 출력 (우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분)

### 게임 실행 결과 예시
```markdown
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



<br><br>



## 필수 기능
- 입력 문자열에서 경주할 자동차 이름을 추출하는 기능
- 자동차가 전진 또는 멈추는 게임 과정을 진행하는 기능
- 각 자동차가 이동한 횟수를 비교하여 우승자를 가리는 기능



## 기능 요구 사항

### Car
- 자동차 이름과 전진 횟수를 가진다.
- 유효성 검사 (자동차 이름)
  - 자동차 이름은 1자 이상 5자 이하로 제한
  - 자동차 이름에 공백 제한
  - 입력 문자열에서 자동차 이름과 쉼표 사이에 공백 허용
  - 자동차 이름의 숫자 포함 허용
  - 자동차 이름에 기호 포함 비허용

### Race
- 입력된 `이동을 시도할 횟수`에 따라 경주를 진행한다. 
- 유효성 검사 (이동을 시도할 횟수)
  - 정수만 입력 가능
  - 1번 이상 2,147,483,647번 이하로 제한
    (1번 이상인 이유: 경주 게임이므로 경주가 무조건 한 번은 진행되어야 한다,
    2,147,483,647번 이하인 이유: int 범위 만큼만 입력 받도록 제한한다.)

### Move
- 무작위 값에 따라 전진 혹은 멈춤을 결정한다.
- 0부터 9사이의 무작위 값을 생성하여 4이상이 나온 경우 전진,
  0부터 9사이의 무작위 값을 생성하여 3이하가 나온 경우 멈춤




## 예외 목록
- `자동차 이름`:
  - 1자 이상 입력이 안 된 경우
  - 6자 이상인 경우
  - 기호가 포함된 경우
  - 공백이 포함된 경우


- `이동을 시도할 횟수`:
  - 0이하가 입력되는 경우
  - 2,147,483,647 초과하는 숫자가 입력된 경우
  - 정수가 아닌 값이 입력되는 경우