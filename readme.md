# wanted-pre-onboarding-backend

</br>

## 1. 요구사항 분석
1. 회사는 채용 공고를 **등록**한다.
   (예시 : 회사 아이디, 채용 포지션, 채용 보상금, 채용내용, 사용 기술)
2. 회사는 채용 공고를 **수정**할 수 있다.
3. 회사는 채용공고를 **삭제**할 수 있다.(Use hard delete)
4. 사용자는 채용공고 **목록을 확인**할 수 있다.
5. 채용공고 **검색 기능 구현**(선택)
6. 채용 **상세 페이지**를 가져옴 (채용 내용이 추가적으로 있음)
7. 사용자는 채용공고에 **지원**할 수 있습니다 (선택)

</br>
**예시데이터**
```json
{
  "회사_id":"회사_id",
  "채용포지션":"백엔드 주니어 개발자",
  "채용보상금":1000000,
  "채용내용":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "사용기술":"Python"
}
```
## 2. 데이터 모델링 설계


1. 회사 vs. 채용공고
    - 각 기업은 다수의 채용 공고를 게시할 수 있습니다. (o)
    - 각 채용 공고는 단일 회사에서 게시됩니다. (x)

2. 사용자 vs. 애플리케이션 
    - 각 사용자는 여러 모집 공고에 대한 신청서를 제출할 수 있습니다. (o)
    - 각 애플리케이션은 단일 사용자와 연결됩니다.(x)

3. 채용 공고 vs. 지원 
    - 각 채용 공고는 여러 사용자로부터 지원서를 받을 수 있습니다(o)
    - 각 지원서는 단일 채용공고로 제출됩니다. (x)

![erd image](https://github.com/Ooyd/wanted-pre-onboarding-backend/blob/master/onboading_erd.PNG?raw=true)

## 3. API 설계
[API문서_feat.postman](https://documenter.getpostman.com/view/20086866/2s9YR85Z9S)


## 4. Conventional commit

| 키워드   | 사용                                                                  |
| -------- | --------------------------------------------------------------------- |
| feat     | 새로운 기능 추가                                                      |
| fix      | 버그 수정                                                             |
| docs     | 문서 수정                                                             |
| style    | 코드 스타일 변경 (코드 포매팅, 세미콜론 누락 등)기능 수정이 없는 경우 |
| design   | 사용자 UI 디자인 변경 (CSS 등)                                        |
| test     | 테스트 코드, 리팩토링 테스트 코드 추가                                |
| refactor | 코드 리팩토링                                                         |
| build    | 빌드 파일 수정                                                        |
| ci       | CI 설정 파일 수정                                                     |
| perf     | 성능 개선                                                             |
| chore    | 빌드 업무 수정, 패키지 매니저 수정 (gitignore 수정 등)                |
| rename   | 파일 혹은 폴더명을 수정만 한 경우                                     |
| remove   | 파일을 삭제만 한 경우                                                 |

