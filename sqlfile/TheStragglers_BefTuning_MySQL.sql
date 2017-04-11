SET @v1 = 204050;
Select * from proj4test.Student where id = @v1; 

SET @v2 = 204050;
SET @v3 = 808125;
Select * from proj4test.Student where id between @v2 and @v3; 

SET @v4 = 'crsCode792250';
Select s.name from proj4test.Student s, proj4test.Transcript t, proj4test.Course c where s.id = t.studId AND t.crsCode = c.crsCode AND c.crsCode = @v4; 

SET @v5 = 'name650236';
Select s.name from proj4test.Student s, proj4test.Transcript transcript,proj4test.Teaching  teaching, proj4test.Professor p where s.id = transcript.studId AND teaching.crsCode = transcript.crsCode AND teaching.profId = p.id  AND p.name = @v5; 

SET @v6 = 'deptId60146';
SET @v7 = 'deptId978847';
Select s.name from proj4test.Student s, proj4test.Course c ,proj4test.Transcript transcript where transcript.studId = s.id AND transcript.crsCode = c.crsCode AND c.deptId = @v6 AND c.deptId != @v7 ;  

SET @v8 = 'deptId617917';
Select s.name from proj4test.Student s, proj4test.Course c ,proj4test.Transcript t where s.id = t.studId AND t.crsCode = c.crsCode AND  c.deptId = @v8 ; 
