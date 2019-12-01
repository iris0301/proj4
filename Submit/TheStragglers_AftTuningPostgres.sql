-- create indexes
CREATE UNIQUE INDEX student_id_index ON Student (id);

CREATE UNIQUE INDEX Professor_id_index ON Professor (id);
CREATE INDEX Professor_name_index ON Professor (name);

CREATE UNIQUE INDEX course_crsCode_index ON Course (crsCode);
CREATE INDEX course_deptId_index ON Course (deptId);

CREATE  INDEX Teaching_crsCode_index ON Teaching (crsCode);
CREATE  INDEX Teaching_profId_index ON Teaching (profId);

CREATE  INDEX Transcript_studId_index ON Transcript (studId);
CREATE  INDEX Transcript_crsCode_index ON Transcript (crsCode);

--1.	List the name of the student with id equal to v1 (id).
Select * from student where id = 30000;

--2.	List the names of students with id in the range of v2 (id) to v3 (inclusive)
Select * from student where id between 10000 and 20000;


--3.	List the names of students who have taken course v4 (crsCode).
Select s.name from student s, Transcript t where s.id = t.studId AND t.crsCode = 'crsCode313028';


--4.	List the names of students who have taken a course taught by professor v5 (name).
Select s.name from student s, Transcript transcript,Teaching  teaching,
   (select id from professor where name = 'name915858') p
   where s.id = transcript.studId AND teaching.crsCode = transcript.crsCode AND teaching.profId = p.id;

--5.	List the names of students who have taken a course from department v6 (deptId), but not v7.
Select s.name from student s, course c ,Transcript transcript where c.deptId = 'deptId476108' AND c.deptId != 'deptId51274' AND transcript.studId = s.id AND transcript.crsCode = c.crsCode ;

--6.	List the names of students who have taken all courses offered by department v8 (deptId).
Select s.name from student s, course c ,Transcript t where s.id = t.studId AND t.crsCode = c.crsCode AND  c.deptId = 'deptId535981'
group by s.name having COUNT(DISTINCT t.crsCode) = (select count(DISTINCT crsCode) from course where deptId = 'deptId535981');

