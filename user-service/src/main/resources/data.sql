insert into users(username, password) values
('TeamUser', '$2a$10$P.EDNKPW25.IQyqFwVQ5.uwBfFEctsRuAFojgq1PFJh3k/3DPSMh2'),
('admin','$2a$10$P.EDNKPW25.IQyqFwVQ5.uwBfFEctsRuAFojgq1PFJh3k/3DPSMh2');

insert into role (role, user_id) values
('ROLE_USER', 1),
('ROLE_USER', 2),
('ROLE_ADMIN', 2);