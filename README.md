# java-racingcar-precourse

## 🚀 구현할 기능 목록

### 1. ⌨️ 경주 참여 자동차 목록 입력

#### 1-1. 경주 참여 자동차 목록 입력

- [ ] 경주에 참여하는 자동차 목록을 입력받는다.

#### 1-2. 자동차 목록 입력값 초기 검증

- [ ] 자동차 목록 입력값을 검증한다.
  - [ ] 각 자동차 이름을 쉼표(,)를 기준으로 구분하였는지 검증한다.

#### 1-3. 자동차 목록 입력값 파싱 및 집합 변환

- [ ] 자동차 목록 입력값을 파싱하여 집합의 형태로 반환한다.
  - [ ] 문자열을 쉼표(,)를 기준으로 파싱한다.
    - [ ] 자동차 이름들을 배열의 형태로 추출한다.
    - [ ] 자동차 이름들 중에서 중복된 이름이 있는지 검증한다.
    - [ ] 자동차 이름들을 집합의 형태로 변환한다. 

#### 1-4. 개별 자동차 이름 검증

- [ ] 개별 자동차 이름을 검증한다.
  - [ ] 이름의 길이가 5자 이하인지 검증한다.
  - [ ] 이름이 오직 알파벳 소문자로만 이루어져있는지 검증한다.

### 2. ⌨️ 경주 시도 횟수 입력

#### 2-1. 시도 횟수 입력

- [ ] 경주 시도 횟수를 입력받는다.

#### 2-2. 시도 횟수 입력값 초기 검증

- [ ] 경주 시도 횟수 입력값을 검증한다.
    - [ ] 입력값이 빈 문자열이 아닌지 검증한다.
    - [ ] 입력값이 정수인지 검증한다.

### 3. 🚗 자동차 경주 진행

#### 3-1. 경주 진행

- [ ] 경주를 시도 횟수만큼 반복해서 진행한다.

#### 3-2. 랜덤하게 자동차 전진

- [x] 0부터 9 사이의 숫자를 뽑는다.
- [x] 랜덤하게 뽑힌 숫자에 따라 자동차의 이동 가능 여부를 반환한다.
- [x] 반환된 결과에 따라 자동차를 전진시키거나, 전진시키지 않는다.

#### 3-3. 실행 결과 출력
            
- [ ] 전진 결과를 "{자동차 이름} : {전진 결과}" 형태로 출력한다.
  - [ ] 이동 거리를 "-"를 반복시켜 출력한다.

### 4. 🏆 최종 우승자 출력

#### 4-1. 최종 우승자 선정

- [x] 모든 자동차 중에서 최대로 이동한 거리를 구한다.
- [x] 최대 이동거리를 바탕으로 우승한 자동차 목록을 구한다.

#### 4-2. 최종 우승자 목록 출력

- [ ] 최종 우승자가 한 명일 경우, "최종 우승자 : {최종 우승자}" 포맷에 맞춰 결과를 출력한다.
- [ ] 최종 우승자가 여럿일 경우, "최종 우승자 : {최종 우승자 1}, {최종 우승자 2}, ...} 포맷에 맞춰 결과를 출력한다. 
  