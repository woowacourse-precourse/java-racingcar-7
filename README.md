# java-racingcar-precourse

## 목표
- Random을 이용해 초간단 자동차 경주 게임을 구현한다.
- 기능을 세분하여 모듈화 한다.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

## 기능 설명
- 자동차 이름들과 시도할 이동 횟수를 입력한다.
- 각 자동차는 매 시도마다 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진한다.
- 매 시도마다 자동차들의 전진 결과를 표시한다. 
- 모든 시도가 끝난 후 우승자를 출력한다.

### Detail
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.

##  Input Format
입력은 다음 2개의 줄이 순서대로 들어온다.
### Line 1. 경주할 자동차 이름 (이름은 쉼표 기준으로 구분)
| input        | 결과                       | 비고         | 
|--------------|--------------------------|------------|
|              | IllegalArgumentException | 빈 입력       |
| ,            | IllegalArgumentException | 빈 자동차 이름   |
| pobi         | 입력 2 대기                  |            |
| pobi,woni,jun | 입력 2 대기                  |            |
| pobi,,woni   | IllegalArgumentException | 빈 자동차 이름   |
| pobicar      | IllegalArgumentException | 5글자가 넘는 이름 |

### Line 2. 시도할 횟수
| input              | 결과                        | 비고       | 
|--------------------|---------------------------|----------|
|                    | IllegalArgumentException  | 빈 입력     |
| a                  | IllegalArgumentException  | 숫자가 아닌 입력 |
| 0                  | 실행 후 output format에 따라 출력 |          |
| 5                  | 실행 후 output format에 따라 출력 |          |
| -1                 | IllegalArgumentException | 음수 입력    |
| 2<sup>32</sup>-1 < | IllegalArgumentException | overflow |


## Output Format
Line 1과 Line 2가 정상적으로 입력되면 매 시도마다 전진 결과를 표시하고, 모든 시도 이후에 우승자를 표시한다.
### Output 1. 매 시도가 끝난 후
| output                                 |
|----------------------------------------|
| pobi : - <br> woni : <br> jun : -      |
| pobi : -- <br> woni : - <br> jun : --  |
| pobi : -- <br> woni : - <br> jun : --- |

### Output 2. 모든 시도가 끝난 후
| output                            |
|-----------------------------------|
| 최종 우승자 : pobi      |
| 최종 우승자 : pobi, jun |

## 구현할 기능
### 1. Input parsing
- [ ] **Line 1**
  - [ ] 입력 메세지 출력
  - [ ] Line 1 입력 받고 저장
  - [ ] 빈 이름 예외처리
  - [ ] 5글자 넘는 이름 예외처리
- [ ] **Line 2**
  - [ ] 입력 메세지 출력
  - [ ] Line 2 입력 받고 저장
  - [ ] 숫자가 아닌 입력 예외처리
  - [ ] overflow 예외 명시적 처리
  
### 2. Race
- [ ] **canMove()**
  - [ ] Randoms 작동 확인
  - [ ] return 값 확인
- [ ] **move()**
  - [ ] canMove == true 인 자동차들에 - 추가

### 3. Output check
- [ ] **Output 1**
  - [ ] 이름 출력
  - [ ] \-갯수 확인
  - [ ] 모두 출력 후 빈 줄 출력
- [ ] **Output 2**
  - [ ] "최종 우승자 : " 출력
  - [ ] 우승자 출력
  - [ ] 공동 우승자 출력

