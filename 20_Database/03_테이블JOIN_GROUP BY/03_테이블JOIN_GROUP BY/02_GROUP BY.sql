/* ===================
SELECT * | [ DISTINCT ] {컬럼명, 컬럼명, ...}
  FROM 테이블명
[WHERE 조건절]
[GROUP BY {컬럼명, ....}
    [HAVING 조건] ] --GROUP BY 절에 대한 조건
[ORDER BY {컬럼명 [ASC | DESC], ....}] 
------------------------------------------------------
-- GROUP BY : 데이터를 그룹핑해서 처리할 경우 사용
-- GROUP BY 문을 사용하면 SELECT 항목에 사용할 수 있는 데이터가 제한됨
---- GROUP BY 절에 사용된 컬럼 또는그룹함수(COUNT, SUM, AVG, MAX, MIN)사용가능
---- 상수값 사용가능(문자열, 숫자, 날짜 값)
--------------------------------
--HAVING 절은 단독으로 사용할 수 없고, 반드시 GROUP BY 절과 함께사용 (종속절)
--HAVING 절 : GROUP BY 절에 의해서 만들어진 데이터에서 검색조건 부여(선택)
--===================*/
--출판사별 출판한 책 개수 구하기

SELECT PUBLISHER, COUNT(*),  --올수있는 컬럼이 제한된다.(GROUP BY 를 써서)/ 상수값, 그룹함수는 가능
       SUM(PRICE), AVG(PRICE), MIN(PRICE),MAX(PRICE)
 FROM BOOK
 GROUP BY PUBLISHER
;


--구매 고객별로 구매금액 합계를 구하시오
SELECT CUSTID, SUM(SALEPRICE)
  FROM ORDERS
GROUP BY CUSTID
;
-- 이름표시 : 이름으로 그룹핑
SELECT C.NAME, SUM(SALEPRICE)
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  ORDER BY SUM(O.SALEPRICE) DESC --많이 구입한 금액부터
  ;

SELECT C.NAME, SUM(SALEPRICE)
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  ORDER BY 2 DESC --많이 구입한 금액부터(위치번호기준)=> 위치가 바뀌면 값이 바뀐다.
  ;

SELECT C.NAME, SUM(SALEPRICE) AS SUM_PRICE
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  ORDER BY SUM_PRICE DESC --많이 구입한 금액부터(그룹함수값 별칭 기준)
  ;
----------------------------
--주문(판매) 테이블의 고객별 데이터 조회(건수, 합계, 평균, 최소, 최대금액)
SELECT CUSTID,
       COUNT(*), SUM(SALEPRICE), TRUNC(AVG(SALEPRICE)),
       MIN(SALEPRICE), MAX(SALEPRICE)
  FROM ORDERS
  GROUP BY CUSTID;
  
--박지성, 추신수 데이터 (건수, 합계, 평균, 최소, 최대금액)
SELECT C.NAME,
       COUNT(*), SUM(SALEPRICE), TRUNC(AVG(SALEPRICE)),
       MIN(SALEPRICE), MAX(SALEPRICE)
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  AND C.NAME IN ('박지성', '추신수')
  GROUP BY C.NAME
  ;
-----------------------------------
--(실습) 고객명 기준으로 고객별 구매데이터 조회(건수, 합계, 평균, 최소, 최대)
---- 추신수, 장미란 고객 2명만 조회(검색)
SELECT C.NAME, COUNT(*), SUM(SALEPRICE), TRUNC(AVG(SALEPRICE)),
       MIN(SALEPRICE), MAX(SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
   AND C.NAME IN ('추신수', '장미란')
GROUP BY C.NAME;

-- 표준SQL 형식
SELECT C.NAME, COUNT(*), SUM(SALEPRICE), TRUNC(AVG(SALEPRICE)),
         MIN(SALEPRICE), MAX(SALEPRICE)
  FROM CUSTOMER C INNER JOIN ORDERS O
  ON C.CUSTID = O.CUSTID
  WHERE C.NAME IN ('추신수', '장미란') 
  GROUP BY C.NAME;
--------------------------------
--HAVING 절은 단독으로 사용할 수 없고, 반드시 GROUP BY 절과 함께사용 (종속절)
--HAVING 절 : GROUP BY 절에 의해서 만들어진 데이터에서 검색조건 부여(선택)
---------------------------------
--3건 이상 구입한 고객 조회
SELECT C.NAME,COUNT(*)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
   HAVING COUNT(*)>=3
;
------------------------------------
--구매한 책중에 20000원 이상의 책을 구입한 사람의 통계 데이터(WHERE랑 GROUP BY 비교)

SELECT C.NAME, COUNT(*) AS CNT, SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)), MIN(o.SALEPRICE), MAX(o.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING MAX(O.SALEPRICE) >= 20000  --2만원 이상 책을 1권이라도 구입한 사람
;
SELECT C.NAME, COUNT(*) AS CNT, SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)), MIN(o.SALEPRICE), MAX(o.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 AND (O.SALEPRICE) >= 20000 --2 만원 이상 책들만 대상으로(테이블에서 대상을 찾음)
GROUP BY C.NAME
;
--(실습) 필요시 조인(JOIN)과 GROUP BY ~ HAVING 구문을 사용해서 처리
--1. 고객이 주문한 도서의 총판매건수, 판매액, 평균값, 최저가, 최고가 구하기
--2. 고객별로 주문한 도서의 총수량, 총판매액 구하기
--3. 고객의 이름과 고객이 주문한 도서의 판매가격을 검색
--4. 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객명으로 정렬
--5. 고객별로 주문한 건수, 합계금액, 평균금액을 구하고(3권 보다 적게 구입한 사람 검색)
--(번외) 고객 중 한 권도 구입 안 한 사람은 누구??
---------------------------
--1. 고객이 주문한 도서의 총판매건수, 판매액, 평균값, 최저가, 최고가 구하기
----(별칭사용시주의) 빈칸, 특수문자 사용시 쌍따옴표("")로 묶어서 표기(한글 사용 자제)/영문과 _만 사용하는 것 권장
select count(*) AS "TOTAL COUNT" --TOTAL_COUNT 사용권장,프로그램 상에서는 쌍따옴표를 허용하지 않기때문에
    , sum(saleprice) AS "판매액 합계"  --한글 사용할 수 있지만 사용하지 말자
    , TRUNC(avg(saleprice)) 평균값AVG
    , min(saleprice) 최저가_MIN
    , max(saleprice) "최고가(MAX)"
    from ORDERS O
;
--2. 고객별로 주문한 도서의 총수량, 총판매액 구하기
select C.NAME, count(*)AS CNT, sum(saleprice) AS SUM_PRICE 
from customer C, ORDERS O
WHERE C.CUSTID = O.CUSTID  --조인조건
GROUP BY C.NAME
;
--3. 고객의 이름과 고객이 주문한 도서의 판매가격을 검색
select C.NAME, O.SALEPRICE
from customer C, ORDERS O
WHERE C.CUSTID = O.CUSTID
ORDER BY C.NAME
;
--4. 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객명으로 정렬
SELECT C.NAME, SUM(O.SALEPRICE)
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
ORDER BY C.NAME
;
--5. 고객별로 주문한 건수, 합계금액, 평균금액을 구하고(3권 보다 적게 구입한 사람 검색)
SELECT C.NAME, COUNT(*) AS CNT,
         SUM(SALEPRICE) AS SUM_PRICE,
         AVG(SALEPRICE) AS AVG_PRICE
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING COUNT(*) < 3
--ORDER BY SUM(O.SALEPRICE) DESC
--ORDER BY 3 DESC
ORDER BY SUM_PRICE DESC --컬럼별칭 사용
;
--(번외) 고객 중 한 권도 구입 안 한 사람은 누구??
SELECT CUSTID FROM CUSTOMER;
SELECT DISTINCT CUSTID FROM ORDERS ORDER BY CUSTID; --DISTINCT : 중복된 값 제거

--(방법1) MINUS : 차집합 처리
SELECT CUSTID FROM CUSTOMER --1,2,3,4,5
MINUS
SELECT CUSTID FROM ORDERS; --1,1,2,3,4,1,...
---------------
--(방법2) 서브쿼리(SUB QUERY)
SELECT *
FROM CUSTOMER
WHERE CUSTID NOT IN (SELECT CUSTID FROM ORDERS)
;
----------------
--(방법3) 외부조인(OUTER JOIN)
--고객 중 한번도 구입내역이 없는 고객 명단 구하기
SELECT C.CUSTID, C.NAME, C.PHONE
      ,O.ORDERID, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID(+) --조인조건(LEFT OUTER JOIN)
AND O.ORDERID IS NULL  --찾을(검색,선택)조건 / NOT NULL조건이 있는 컬럼으로 비교하기
;
--표준 SQL(LEFT OUTER JOIN)
SELECT *
FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
    ON C.CUSTID = O.CUSTID --조인조건(LEFT OUTER JOIN)
WHERE O.ORDERID IS NULL  --찾을(검색,선택)조건 / NOT NULL조건이 있는 컬럼으로 비교하기
;

SELECT C.NAME
FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
ON C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING COUNT(ORDERID) = 0
;


--쿼리의 문제는 GROUP BY 절에 있는 "HAVING O.ORDERID IS NULL" 부분입니다. 
--이 부분은 GROUP BY 절에 있는 열 중 하나를 필터링하는 조건이어야 하는데, 
--"O.ORDERID"는 GROUP BY 절에 나열된 열이 아닙니다. 이로 인해 "not a GROUP BY expression" 오류가 발생합니다.
SELECT C.NAME
FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
ON C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING O.SALEPRICE IS NULL
;

--RIGHT OUTER JOIN
SELECT *
FROM  ORDERS O RIGHT OUTER JOIN CUSTOMER C
    ON C.CUSTID = O.CUSTID --조인조건(LEFT OUTER JOIN)
WHERE O.ORDERID IS NULL 
;
--외부조인(우측기준)
SELECT C.CUSTID, C.NAME, C.PHONE
      ,O.ORDERID, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE O.CUSTID(+) = C.CUSTID  --부족한 부분에 (+)를 붙인다.(기준이 아닌 곳)
AND O.ORDERID IS NULL  --찾을(검색,선택)조건 / NOT NULL조건이 있는 컬럼으로 비교하기
;
--------------------------------
