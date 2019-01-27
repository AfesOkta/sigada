INSERT INTO c_security_permission (id, permission_label, permission_value) VALUES
('USER_LOGGED_IN', 'Get User Loggin Information', 'ROLE_USER_LOGGED_IN'),
('DATA_KEPEL','Get Kelompok Pelayanan Information','ROLE_KEPEL'),
('DATA_KOMISI','Get Data Komisi','ROLE_KOMISI'),
('DATA_WAKTU_IBADAH','Get Waktu Ibadah','ROLE_WAKTU_IBADAH'),
('DATA_KEUANGAN','Get Data Keuangan','ROLE_KEUANGAN'),
('DATA_IDENTITAS_SIDANG','Get Identitas Sidang','ROLE_IDENTITAS_SIDANG'),
('DATA_JEMAAT','Get Data Jemaat','ROLE_Jemaat'),
('DATA_MUTASI_JEMAAT','Get Data Mutasi Jemaat','ROLE_MUTASI_JEMAAT'),
('DATA_ORGANISASI','Get Data Organisasi','ROLE_ORGANISASI'),
('DATA_PENJADWALAN','Get Data Penjadwalan','ROLE_PENJADWALAN'),
('DATA_TRANSAKSI_KEUANGAN','Transaksi Data Keuangan','ROLE_TRANSAKSI_KEUANGAN');

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
