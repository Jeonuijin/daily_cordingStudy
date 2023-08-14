/* ** 실습문제 : HR유저(DB)에서 요구사항 해결 **********
--1) 사번(employee_id)이 100인 직원 정보 전체 보기
--2) 월급(salary)이 15000 이상인 직원의 모든 정보 보기
--3) 월급이 15000 이상인 사원의 사번, 이름(LAST_NAME), 입사일(hire_date), 월급여 정보 보기
--4) 월급이 10000 이하인 사원의 사번, 이름(LAST_NAME), 입사일, 월급여 정보 보기
---- (급여가 많은 사람부터)
--5) 이름(first_name)이 john인 사원의 모든 정보 조회
--6) 이름(first_name)이 john인 사원은 몇 명인가?
--7) 2008년에 입사한 사원의 사번, 성명('first_name last_name'), 월급여 정보 조회
---- 성명 출력예) 'Steven King'
--8) 월급여가 20000~30000 구간인 직원 사번, 성명(last_name first_name), 월급여 정보 조회
--9) 관리자ID(MANAGER_ID)가 없는 사람 정보 조회
--10) 직종(job_id)코드 'IT_PROG'에서 가장 많은 월급여는 얼마
---------------------------------
--11) 직종별 최대 월급여 검색
--12) 직종별 최대 월급여 검색하고, 최대 월급여가 10000이상인 직종 조회
--13) 직종별 평균급여 이상인 직원 조회
*****************************/
--1) 사번(employee_id)이 100인 직원 정보 전체 보기
SELECT *
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 100
;
--2) 월급(salary)이 15000 이상인 직원의 모든 정보 보기
SELECT *
FROM EMPLOYEES
WHERE SALARY >= 15000
;
--3) 월급이 15000 이상인 사원의 사번, 이름(LAST_NAME), 입사일(hire_date), 월급여 정보 보기
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY
FROM EMPLOYEES
WHERE SALARY >= 15000
;
--4) 월급이 10000 이하인 사원의 사번, 이름(LAST_NAME), 입사일, 월급여 정보 보기
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY
FROM EMPLOYEES
WHERE SALARY <= 10000
;
---- (급여가 많은 사람부터)
--5) 이름(first_name)이 john인 사원의 모든 정보 조회
SELECT *
FROM EMPLOYEES
WHERE LOWER(FIRST_NAME) = 'john'
;
--6) 이름(first_name)이 john인 사원은 몇 명인가?
SELECT COUNT(*)
FROM EMPLOYEES
WHERE LOWER(FIRST_NAME) = 'john'
;
--7) 2008년에 입사한 사원의 사번, 성명('first_name last_name'), 월급여 정보 조회
---- 성명 출력예) 'Steven King' (컬럼명만들기)
SELECT EMPLOYEE_ID, FIRST_NAME||' '||LAST_NAME AS "성명", SALARY
FROM EMPLOYEES
WHERE HIRE_DATE >= TO_DATE('2008/01/01')
;
--8) 월급여가 20000~30000 구간인 직원 사번, 성명(last_name first_name), 월급여 정보 조회
SELECT EMPLOYEE_ID, LAST_NAME||' '||FIRST_NAME AS "성명", SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 2000 AND 3000
;
--9) 관리자ID(MANAGER_ID)가 없는 사람 정보 조회
SELECT *
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL
;
--10) 직종(job_id)코드 'IT_PROG'에서 가장 많은 월급여는 얼마
SELECT MAX(SALARY)
FROM EMPLOYEES
WHERE JOB_ID = 'IT_PROG'
;
---------------------------------
--GROUP BY
--11) 직종별 최대 월급여 검색
SELECT J.JOB_TITLE, J.MAX_SALARY
FROM EMPLOYEES E, JOBS J
WHERE E.JOB_ID = J.JOB_ID
GROUP BY J.JOB_TITLE, J.MAX_SALARY
;
--12) 직종별 최대 월급여 검색하고, 최대 월급여가 10000이상인 직종 조회
SELECT J.JOB_TITLE, J.MAX_SALARY
FROM EMPLOYEES E, JOBS J
WHERE E.JOB_ID = J.JOB_ID AND J.MAX_SALARY >= 10000
GROUP BY J.JOB_TITLE, J.MAX_SALARY
;
--13) 직종별 평균급여 이상인 직원 조회
SELECT FIRST_NAME, AVG(SALARY), EMPLOYEE_ID
FROM EMPLOYEES
GROUP BY EMPLOYEE_ID, FIRST_NAME
;

SELECT B.EMPLOYEE_ID, B.SALARY, B.JOB_ID, B.FIRST_NAME
    FROM (SELECT AVG(SALARY) AS "평균급여", JOB_ID FROM EMPLOYEES GROUP BY JOB_ID) A,
        (SELECT JOB_ID ,SALARY, EMPLOYEE_ID ,FIRST_NAME FROM EMPLOYEES) B
    WHERE A.JOB_ID = B.JOB_ID
    AND B.SALARY >= "평균급여"
    ORDER BY B.JOB_ID, B.SALARY, B.FIRST_NAME
;
--주녕이방법
SELECT E.EMPLOYEE_ID, E.SALARY, A.* FROM
(SELECT JOB_ID, AVG(SALARY) AS AVG FROM EMPLOYEES GROUP BY JOB_ID) A INNER JOIN EMPLOYEES E ON
A.JOB_ID =  E.JOB_ID 
WHERE A.AVG <= E.SALARY
ORDER BY A.JOB_ID
;