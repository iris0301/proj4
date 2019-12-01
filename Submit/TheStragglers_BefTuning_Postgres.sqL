--1.	List the name of the student with id equal to v1 (id).
Select * from student where id = 30000; 

--2.	List the names of students with id in the range of v2 (id) to v3 (inclusive)
Select * from student where id between 10000 and 20000; 


--3.	List the names of students who have taken course v4 (crsCode).
Select s.name from student s, Transcript t, Course c where s.id = t.studId AND t.crsCode = c.crsCode AND c.crsCode = 'crsCode313028';

--4.	List the names of students who have taken a course taught by professor v5 (name).
Select s.name from student s, Transcript transcript,Teaching  teaching, 
   Professor p where s.id = transcript.studId AND teaching.crsCode = transcript.crsCode AND teaching.profId = p.id  AND p.name = 'name915858';


--5.	List the names of students who have taken a course from department v6 (deptId), but not v7.
Select s.name from student s, course c ,Transcript transcript where transcript.studId = s.id AND transcript.crsCode = c.crsCode AND  c.deptId = 'deptId476108' AND c.deptId != 'deptId51274' ;  


--6.	List the names of students who have taken all courses offered by department v8 (deptId).
Select s.name from student s, course c ,Transcript t where s.id = t.studId AND t.crsCode = c.crsCode AND  c.deptId = 'deptId535981'
group by s.name having COUNT(DISTINCT t.crsCode) = (select count(DISTINCT crsCode) from course where deptId = 'deptId535981');


