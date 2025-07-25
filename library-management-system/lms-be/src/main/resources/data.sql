insert into books(id,title,author) values(10,'Book-1','Author-1');
insert into books(id,title,author) values(20,'Book-2','Author-2');
insert into books(id,title,author) values(30,'Book-3','Author-3');
insert into books(id,title,author) values(40,'Book-4','Author-4');

insert into students values(50,'Student-1');
insert into students values(51,'Student-2');
insert into students values(52,'Student-3');

insert into student_books(id,book_id,stud_id,status) values(41,10,50,'REQ');
insert into student_books(id,book_id,stud_id,status) values(42,20,51,'APP');
insert into student_books(id,book_id,stud_id,status) values(43,40,52,'REJ');