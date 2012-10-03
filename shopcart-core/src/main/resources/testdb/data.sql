INSERT INTO app_user(email, password) VALUES ('admin@test.com','5f4dcc3b5aa765d61d8327deb882cf99');
INSERT INTO app_user(email, password) VALUES ('user@test.com','5f4dcc3b5aa765d61d8327deb882cf99');

INSERT INTO app_user_role(role) VALUES ('ROLE_ADMIN');
INSERT INTO app_user_role(role) VALUES ('ROLE_USER');

INSERT INTO app_user_user_role(app_user_id,app_user_role_id) VALUES(1,1);
INSERT INTO app_user_user_role(app_user_id,app_user_role_id) VALUES(1,2);
--INSERT INTO app_user_user_role(app_user_id,app_user_role_id) VALUES(2,2);

