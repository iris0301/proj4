#set profiling to track duration of query time
SET profiling =  1;
SET @v1 = 204050;
SET @v2 = 204050;
SET @v3 = 808125;
SET @v4 = 'crsCode792250';
SET @v5 = 'name650236';
SET @v6 = 'deptId60146';
SET @v7 = 'deptId978847';
SET @v8 = 'deptId617917';

#query 1
Select * from Student where id = @v1; 

#query 2
Select * from Student where id between @v2 and @v3; 

#query 3
Select s.name from Student s, Transcript t, Course c where s.id = t.studId AND t.crsCode = c.crsCode AND c.crsCode = @v4; 

#query 4
Select s.name from Student s, Transcript t,Teaching  te, Professor p where s.id = t.studId AND te.crsCode = t.crsCode AND te.profId = p.id  AND p.name = @v5; 

#query 5
Select s.name from Student s, Course c ,Transcript t where t.studId = s.id AND t.crsCode = c.crsCode AND c.deptId = @v6 AND c.deptId != @v7 ;  

#query 6
Select s.name from Student s, Course c ,Transcript t where s.id = t.studId AND t.crsCode = c.crsCode AND  c.deptId = @v8 ; 

#displays the profile table that keeps track of query duration
SHOW PROFILES;