# NS-baragi-SpringBoot
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
 
날씨바라기 백엔드 서버입니다.

* [원본 Repository](https://github.com/orgs/IMS-Side/repositories)

# API 명세서

## 1. 주소

### 1.1 행정동코드 가져오기 by 시군구명

* 요약: 시도(경기도, 서울특별시 등)와 시군구(안산시, 종로구 등)를 입력하면 매칭되는 행정동 코드를 가져옵니다.

    * 단, 현재 DB와 완전히 매칭되어야 검색이 가능한 단점이 존재합니다.

* Endpoint: `/address/find?sido=&sigungu=`

* Method: `GET`

* Request: 
    * `sido`: String // URL Param 
    * `sigungu`: String // URL Param 


* Response: 
    * `code`: Long

* Success Example:

    * `/address/find?sido=서울특별시&sigungu=종로구`:
    
    ![image](https://github.com/user-attachments/assets/93227bfc-4795-4cf2-a1c8-3d901570f5a1)

## 2. 날씨 동의/비동의

### 2.1 현재 날씨 공감 정보 가져오기 by 행정동코드

* 요약: 행정동코드를 입력하면 해당 구역의 공감개수를 가져옵니다.

* Endpoint: `/likes/result/{code}`

* Method: `GET`

* Request: 

    * `code`: Long // URL Param 

* Response: 
    * `code`: Long
    * `likes`: int
    * `dislikes`: int

* Success Example:
    * `likes/result/4139000000`

    ![image](https://github.com/user-attachments/assets/61a533c4-f276-42c3-85ac-f95d7eb8c85b)

### 2.2 날씨 공감/비공감 입력

* 요약: 현재 날씨에 공감하는지를 서버로 전송합니다.

* Endpoint: `/likes/add?code=&likes=`

* Method: `GET`

* Request parameters: 
    * `code`: Long 
    * `like`: int  // 1이면 공감, 0이면 비공감(나머지는 무시됨)

* Response: `None`

* Success Example:

![image](https://github.com/user-attachments/assets/8a4e904d-bdb4-49c7-8d22-7d671cf2f218)


## 3. 체감 날씨

### 3.1 날씨 설문조사

* 요약: 현재 체감하는 날씨 정보를 서버로 전송합니다.

    * 각 날씨 항목에는 고유코드를 부여하였습니다. {비:1, 습도:2, 햇살:3, 바람:4, 하늘상태:5}
    * 또한 응답에 해당하는 부분은 왼쪽부터 1로 시작하는 값으로 설정하였습니다. [1, 2, 3, 4] // 단, 4는 하늘상태의 "흐림" 전용
     
    * 참고 이미지: 
     <img src="https://github.com/user-attachments/assets/9217dbb2-c35e-42af-811d-48fcf55a8933" width="360" height="auto" />

* Endpoint: `/weather/add`

* Method: `POST`

* Request Body: 
    * `code`: Long
    * `surveylist`: 
        * `id`: int // 1(비), 2(습도), 3(햇살), 4(바람), 5(하늘상태)
        * `value`: int // 1, 2, 3, 4(하늘상태-흐림 전용)

* Response: `None`

* Success Example:

    ![image](https://github.com/user-attachments/assets/c714482b-ed0a-47c8-9703-7918fba4ea0c)


### 3.2 체감날씨 조회

* 요약: 특정 지역의 사람들이 현재 체감하는 날씨정보를 가져옵니다.

    * value1은 설문조사 창의 가장 왼쪽을, value3은 가장 오른쪽을 의미합니다. 예를 들어 비의 경우, value1이 "없음"을, value3이 "많음"을 의미합니다.
    * 단, 하늘 상태의 경우 유일하게 value4를 활용하며, 이때 value4는 "흐림"을 의미합니다.
    * 모든 value(n) 변수는 투표 수를 의미합니다.

* Endpoint: `weather/count/{code}`

* Method: `GET`

* Request: 
    * `code`: Long 

* Response:
    * `id` : int // DB PK입니다 무시해주세요
    * `code`: Long
    * `serialNumber`: int
    * `name`: String
    * `value1Count`: int
    * `value2Count`: int
    * `value3Count`: int
    * `value4Count`: int
    * `totalCount`: int // 총합

* Success Example:
    
    ![image](https://github.com/user-attachments/assets/82f2e95f-c244-4403-9269-1b6b178a553f)


## 4.체감 옷

### 4.1 옷 설문조사

* 요약: 사용자가 입은 옷 정보들을 서버로 전송합니다.

<details>
<summary>옷 고유번호 목록</summary>
    실제 통신 시 영문명을 기준으로 합니다!

    아우터 - 카디건(101), 얇은 카디건(102), 자켓(103), 야상(104), 가죽자켓(105), 트렌치코트(106), 코트(107), 두꺼운 코트(108), 패딩(109)

    outer: cardigan(101), thin cardigan(102), jacket(103), field jacket(104), leather jacket(105), trench coat(106), coat(107), winter coat(108), puffer jacket(109)


    상의: 민소매(201), 반팔(202), 얇은 셔츠(203), 긴팔(204), 얇은 니트(205), 니트(206), 맨투맨(207)

    top: sleeveless(201), t-shirt(202), linen shirt(203), longsleeve(204), light knit sweater(205), knit sweater(206), sweatshirt(207)


    하의: 반바지(301), 면바지(302), 청바지(303) 

    bottom: shorts(301), cotton pants(302), jeans(303) 


    기타: 목도리(401), 기모제품(402), 레깅스(403), 스타킹(404)

    others: scarf(401), fleece-lined(402), leggings(403), stockings(404)


</details>

* Endpoint: `/cloth/add`

* Method: `POST`

* Request Body:
    * `code` : Long
    * `surveylist`:
        * `serial_number`: int // 옷 고유번호(위에 서술)
        * `value`: int // [1(추움), 2(좋음), 3(더움)]

* Response: `None`

* Success Example

    <img src="https://github.com/user-attachments/assets/e937f1dd-29aa-43e2-b457-580beca39243" height=500 width="auto"/>

### 4.2 옷 비율 조회

* 요약: 카테고리(외투, 상의, 하의) 별로 득표수가 가장 높은 상위 2개의 옷 정보를 제공합니다.

* Endpoint: `/cloth/count/toptwo/{code}`

* Method: `GET`

* Request: 
    * `code`: Long // URL Param

* Response:
    * `category` : List<ClothDTO>
        * `id` : int // DB PK입니다 무시해주세요
        * `code` : Long
        * `serialNumber` : int // 옷 고유번호
        * `name`: String // 옷 이름
        * `category`: String // 카테고리
        * `cold_count`: int
        * `normal_count`: int
        * `hot_count`: int
        * `total`: int // 총합

* Success Example:
    
    ![image](https://github.com/user-attachments/assets/c0042c3c-1258-4188-bba1-8ec617e8f6c9)



