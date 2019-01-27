CREATE TABLE c_password_reset_token (
    id character varying(255) NOT NULL,
    expiry_date timestamp without time zone,
    token character varying(255) NOT NULL,
    id_user character varying(255) NOT NULL
);

CREATE TABLE c_security_permission (
    id character varying(255) NOT NULL,
    permission_label character varying(255) NOT NULL,
    permission_value character varying(255) NOT NULL
);

CREATE TABLE c_security_role (
    id character varying(255) NOT NULL,
    description character varying(255),
    name character varying(255) NOT NULL
);

CREATE TABLE c_security_role_permission (
    id_role character varying(255) NOT NULL,
    id_permission character varying(255) NOT NULL
);

CREATE TABLE c_security_user (
    id character varying(255) NOT NULL,
    active boolean NOT NULL,
    user_name character varying(255) NOT NULL,
    id_role character varying(255) NOT NULL
);

CREATE TABLE c_security_user_password (
    id_user character varying(36) NOT NULL,
    password character varying(255) NOT NULL
);

INSERT INTO c_security_permission (id, permission_label, permission_value) VALUES
('USER_LOGGED_IN', 'Get User Loggin Information', 'ROLE_USER_LOGGED_IN');

INSERT INTO c_security_role (id, description, name) VALUES
('ADMINISTRATOR', 'Application Administrator', 'ADMINISTRATOR'),
('USER', 'USER', 'USER');

INSERT INTO c_security_role_permission (id_role, id_permission) VALUES
('ADMINISTRATOR', 'USER_LOGGED_IN'),
('USER', 'USER_LOGGED_IN');

INSERT INTO c_security_user (id, active, user_name, id_role) VALUES
('admin', true,'admin', 'ADMINISTRATOR');

INSERT INTO c_security_user_password (id_user, password) VALUES
('admin', '$2a$08$LS3sz9Ft014MNaIGCEyt4u6VflkslOW/xosyRbinIF9.uaVLpEhB6');
