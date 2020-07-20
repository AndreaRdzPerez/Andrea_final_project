insert into users(username, password) values
('referee', '$2a$10$P.EDNKPW25.IQyqFwVQ5.uwBfFEctsRuAFojgq1PFJh3k/3DPSMh2'),
('teamCaptain', '$2a$10$P.EDNKPW25.IQyqFwVQ5.uwBfFEctsRuAFojgq1PFJh3k/3DPSMh2'),
('admin','$2a$10$P.EDNKPW25.IQyqFwVQ5.uwBfFEctsRuAFojgq1PFJh3k/3DPSMh2');

insert into role (role, user_id) values
('ROLE_REFEREE', 1),
('ROLE_TEAM', 1),
('ROLE_TEAM', 2),
('ROLE_REFEREE', 3),
('ROLE_TEAM', 3),
('ROLE_ADMIN', 3);