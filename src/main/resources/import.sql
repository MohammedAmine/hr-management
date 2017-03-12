-- Create company
insert into Company (id, name, businessSector, logoURL, version) values (1, 'Degetel', 'IT Consulting', 'http://www.sulitest.org/imgs/shareimg/4/degetel.png', 1);
-- Create employees
insert into Employee (id, firstName, lastName, jobFunction, salary, employer_id, version) values (1, 'Mohammed Amine', 'El Jirari', 'Software Engineer', 50000, 1, 1);
insert into Employee (id, firstName, lastName, jobFunction, salary, employer_id, version) values (2, 'Claire', 'Sinanian', 'Business Engineer', 75000, 1, 1);