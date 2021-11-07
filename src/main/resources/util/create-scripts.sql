INSERT INTO public.student (id, email, password, date_of_birth, first_name, last_name, phone_number) VALUES ('eed75828-3ed7-11ec-9bbc-0242ac130002', 'john.doe@gmail.com', 'johndoe', '1999-01-01', 'John', 'Doe', '0777444333');
INSERT INTO public.student (id, email, password, date_of_birth, first_name, last_name, phone_number) VALUES ('eed75c56-3ed7-11ec-9bbc-0242ac130002', 'jane.doe@gmail.com', 'janedoe', '2000-01-01', 'Jane', 'Doe', '0777333999');
INSERT INTO public.student (id, email, password, date_of_birth, first_name, last_name, phone_number) VALUES ('eed75d46-3ed7-11ec-9bbc-0242ac130002', 'thomas.stone@gmail.com', 'thomas', '2000-05-05', 'Thomas', 'Stone', '0999333222');

INSERT INTO public.education_details (id, faculty, specialization, university, year_of_study, student_id) VALUES ('a7a4b4c2-3edd-11ec-9bbc-0242ac130002', 0, 0, 0, '3rd year', 'eed75828-3ed7-11ec-9bbc-0242ac130002');
INSERT INTO public.education_details (id, faculty, specialization, university, year_of_study, student_id) VALUES ('a7a4a86a-3edd-11ec-9bbc-0242ac130002', 0, 1, 1, '2nd year', 'eed75c56-3ed7-11ec-9bbc-0242ac130002');
INSERT INTO public.education_details (id, faculty, specialization, university, year_of_study, student_id) VALUES ('a7a4a07c-3edd-11ec-9bbc-0242ac130002', 6, 3, 2, '5th year', 'eed75d46-3ed7-11ec-9bbc-0242ac130002');

INSERT INTO public.domain (id, description, domain_type) VALUES ('489df338-3f16-11ec-9bbc-0242ac130002', 'Information Technology', 0);
INSERT INTO public.domain (id, description, domain_type) VALUES ('489df554-3f16-11ec-9bbc-0242ac130002', 'Medicine & Care', 1);
INSERT INTO public.domain (id, description, domain_type) VALUES ('489df7f2-3f16-11ec-9bbc-0242ac130002', 'Chemistry Field ', 2);
INSERT INTO public.domain (id, description, domain_type) VALUES ('489df8d8-3f16-11ec-9bbc-0242ac130002', 'Military & Police Domain', 3);
INSERT INTO public.domain (id, description, domain_type) VALUES ('489df9a0-3f16-11ec-9bbc-0242ac130002', 'Finance Domain', 4);

INSERT INTO public.company (id, email, password, address, name, domain_id) VALUES ('eed76dd6-3ed7-11ec-9bbc-0242ac130002', 'sintern@company.com', 'sintern', 'Cluj-Napoca', 'SIntern', '489df338-3f16-11ec-9bbc-0242ac130002');
INSERT INTO public.company (id, email, password, address, name, domain_id) VALUES ('eed76ab6-3ed7-11ec-9bbc-0242ac130002', 'medcare@company.com', 'medcare', 'Cluj-Napoca', 'Med Care', '489df554-3f16-11ec-9bbc-0242ac130002');
INSERT INTO public.company (id, email, password, address, name, domain_id) VALUES ('4cbcf712-3ede-11ec-9bbc-0242ac130002', 'computersit@company.com', 'computersit', 'Bucharest', 'ComputersIT', '489df338-3f16-11ec-9bbc-0242ac130002');

INSERT INTO public.open_intern_position (id, available_positions, department, description, name, company_id) VALUES ('4cbcf0d2-3ede-11ec-9bbc-0242ac130002', 5, 'Java Backend', 'Java Backend Internship with Spring Framework, Hibernate ORM', 'Java Backend Internship', 'eed76dd6-3ed7-11ec-9bbc-0242ac130002');
INSERT INTO public.open_intern_position (id, available_positions, department, description, name, company_id) VALUES ('4cbcecea-3ede-11ec-9bbc-0242ac130002', 2, 'Web Development', 'Web Development Internship, Angular Framework', 'Angular Web Dev. Internship', 'eed76dd6-3ed7-11ec-9bbc-0242ac130002');
INSERT INTO public.open_intern_position (id, available_positions, department, description, name, company_id) VALUES ('4cbcfd3e-3ede-11ec-9bbc-0242ac130002', 4, 'C# Backend', 'C# for Backend Internship', 'C# Internship', '4cbcf712-3ede-11ec-9bbc-0242ac130002');
