--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.15
-- Dumped by pg_dump version 9.5.15

-- Started on 2019-01-26 22:58:25

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 189 (class 1259 OID 24635)
-- Name: c_password_reset_token; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.c_password_reset_token (
    id character varying(255) NOT NULL,
    expiry_date timestamp without time zone,
    token character varying(255) NOT NULL,
    id_user character varying(255) NOT NULL
);


ALTER TABLE public.c_password_reset_token OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 24641)
-- Name: c_security_permission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.c_security_permission (
    id character varying(255) NOT NULL,
    permission_label character varying(255) NOT NULL,
    permission_value character varying(255) NOT NULL
);


ALTER TABLE public.c_security_permission OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 24649)
-- Name: c_security_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.c_security_role (
    id character varying(255) NOT NULL,
    description character varying(255),
    name character varying(255) NOT NULL
);


ALTER TABLE public.c_security_role OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 24657)
-- Name: c_security_role_permission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.c_security_role_permission (
    id_role character varying(255) NOT NULL,
    id_permission character varying(255) NOT NULL
);


ALTER TABLE public.c_security_role_permission OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 24675)
-- Name: c_security_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.c_security_user (
    id character varying(255) NOT NULL,
    active boolean NOT NULL,
    user_name character varying(255) NOT NULL,
    id_role character varying(255) NOT NULL
);


ALTER TABLE public.c_security_user OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 24688)
-- Name: c_security_user_password; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.c_security_user_password (
    id_user character varying(36) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE public.c_security_user_password OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 24428)
-- Name: rmjbt; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rmjbt (
    id character varying(255) NOT NULL,
    jbkod character(3) NOT NULL,
    jbnam character varying(25)
);


ALTER TABLE public.rmjbt OWNER TO postgres;

--
-- TOC entry 2189 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN rmjbt.jbkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmjbt.jbkod IS 'Kode Jabatan';


--
-- TOC entry 2190 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN rmjbt.jbnam; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmjbt.jbnam IS 'Nama Jabatan';


--
-- TOC entry 185 (class 1259 OID 24443)
-- Name: rmkel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rmkel (
    id character varying(255) NOT NULL,
    klkod character(4) NOT NULL,
    klnam character varying(40),
    klkkk character varying(8),
    kpkod character(2)
);


ALTER TABLE public.rmkel OWNER TO postgres;

--
-- TOC entry 2191 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN rmkel.klkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkel.klkod IS 'Kode Keluarga';


--
-- TOC entry 2192 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN rmkel.klnam; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkel.klnam IS 'Nama Keluarga';


--
-- TOC entry 2193 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN rmkel.klkkk; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkel.klkkk IS 'Kode Kepala KLG';


--
-- TOC entry 2194 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN rmkel.kpkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkel.kpkod IS 'Kode Kepel';


--
-- TOC entry 188 (class 1259 OID 24458)
-- Name: rmkmj; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rmkmj (
    id character varying(255) NOT NULL,
    kmprd character varying(9) NOT NULL,
    kmkod character(3),
    jbkod character varying(8),
    kmtgl date,
    jmkod character varying(8),
    kmtgs date,
    kmakt boolean
);


ALTER TABLE public.rmkmj OWNER TO postgres;

--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN rmkmj.kmtgl; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkmj.kmtgl IS 'tgl menjabat';


--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN rmkmj.jmkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkmj.jmkod IS 'kode jemaat';


--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN rmkmj.kmtgs; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkmj.kmtgs IS 'tgl akhir jabat';


--
-- TOC entry 183 (class 1259 OID 24433)
-- Name: rmkms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rmkms (
    id character varying(255) NOT NULL,
    kmkod character(2) NOT NULL,
    kmnam character varying(30),
    kmsng character varying(10)
);


ALTER TABLE public.rmkms OWNER TO postgres;

--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 183
-- Name: TABLE rmkms; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.rmkms IS 'Komisi';


--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rmkms.kmkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkms.kmkod IS 'Kode komisi';


--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rmkms.kmnam; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkms.kmnam IS 'Nama Komisi';


--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rmkms.kmsng; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkms.kmsng IS 'Singkatan';


--
-- TOC entry 184 (class 1259 OID 24438)
-- Name: rmkpl; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rmkpl (
    id character varying(255) NOT NULL,
    kpkod character(2) NOT NULL,
    kpnam character varying(35),
    kppnt character varying(8),
    kpdkn character varying(8)
);


ALTER TABLE public.rmkpl OWNER TO postgres;

--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 184
-- Name: TABLE rmkpl; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.rmkpl IS 'Table Kelompok Pelayanan';


--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN rmkpl.kpdkn; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkpl.kpdkn IS 'Diaken';


--
-- TOC entry 186 (class 1259 OID 24448)
-- Name: rpjmt; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rpjmt (
    id character varying(255) NOT NULL,
    jmkod character varying(8) NOT NULL,
    jmnam character varying(30),
    klkod character(4),
    kpkod character(2),
    jmtgl date,
    jmhut character varying(5),
    jmbpt boolean,
    jmsid boolean,
    jmnkh character(1),
    jmkrj character(1),
    jmpdk character(1),
    kmkod character(1),
    jmhub character(1),
    jmjkl character(1)
);


ALTER TABLE public.rpjmt OWNER TO postgres;

--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.jmnam; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmnam IS 'Nama Jemaat';


--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.klkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.klkod IS 'Kode Keluarga';


--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.kpkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.kpkod IS 'Kode Kepel';


--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.jmtgl; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmtgl IS 'Tgl Lahir';


--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.jmhut; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmhut IS 'Tgl-Bln Lahir';


--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.jmbpt; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmbpt IS 'Baptis';


--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.jmsid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmsid IS 'Sidi';


--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.jmnkh; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmnkh IS 'nikah';


--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.jmkrj; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmkrj IS 'Jenis Kerja';


--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.jmpdk; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmpdk IS 'Jenis Pendidikan';


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.jmhub; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmhub IS 'hub dgn kk';


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rpjmt.jmjkl; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmjkl IS 'jns kelamin';


--
-- TOC entry 187 (class 1259 OID 24453)
-- Name: rpjps; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rpjps (
    id character varying(255) NOT NULL,
    jmkod character varying(8) NOT NULL,
    jmnam character varying(30),
    jpsid character varying(30)
);


ALTER TABLE public.rpjps OWNER TO postgres;

--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 187
-- Name: COLUMN rpjps.jpsid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjps.jpsid IS 'Ke Sidang';


--
-- TOC entry 2050 (class 2606 OID 24648)
-- Name: c_security_permission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.c_security_permission
    ADD CONSTRAINT c_security_permission_pkey PRIMARY KEY (id);


--
-- TOC entry 2054 (class 2606 OID 24664)
-- Name: c_security_role_permission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.c_security_role_permission
    ADD CONSTRAINT c_security_role_permission_pkey PRIMARY KEY (id_role, id_permission);


--
-- TOC entry 2052 (class 2606 OID 24656)
-- Name: c_security_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.c_security_role
    ADD CONSTRAINT c_security_role_pkey PRIMARY KEY (id);


--
-- TOC entry 2058 (class 2606 OID 24692)
-- Name: c_security_user_password_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.c_security_user_password
    ADD CONSTRAINT c_security_user_password_pkey PRIMARY KEY (id_user);


--
-- TOC entry 2056 (class 2606 OID 24682)
-- Name: c_security_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.c_security_user
    ADD CONSTRAINT c_security_user_pkey PRIMARY KEY (id);


--
-- TOC entry 2024 (class 2606 OID 24704)
-- Name: jbkod_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmjbt
    ADD CONSTRAINT jbkod_unique UNIQUE (jbkod);


--
-- TOC entry 2040 (class 2606 OID 24716)
-- Name: jmkod_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rpjmt
    ADD CONSTRAINT jmkod_unique UNIQUE (jmkod);


--
-- TOC entry 2036 (class 2606 OID 24708)
-- Name: klkod_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkel
    ADD CONSTRAINT klkod_unique UNIQUE (klkod);


--
-- TOC entry 2028 (class 2606 OID 24712)
-- Name: kmkod_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkms
    ADD CONSTRAINT kmkod_unique UNIQUE (kmkod);


--
-- TOC entry 2046 (class 2606 OID 24710)
-- Name: kmprd_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkmj
    ADD CONSTRAINT kmprd_unique UNIQUE (kmprd);


--
-- TOC entry 2032 (class 2606 OID 24714)
-- Name: kpkod_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkpl
    ADD CONSTRAINT kpkod_unique UNIQUE (kpkod);


--
-- TOC entry 2026 (class 2606 OID 24432)
-- Name: rmjbt_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmjbt
    ADD CONSTRAINT rmjbt_pkey PRIMARY KEY (id);


--
-- TOC entry 2038 (class 2606 OID 24447)
-- Name: rmkel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkel
    ADD CONSTRAINT rmkel_pkey PRIMARY KEY (id);


--
-- TOC entry 2048 (class 2606 OID 24462)
-- Name: rmkmj_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkmj
    ADD CONSTRAINT rmkmj_pkey PRIMARY KEY (id);


--
-- TOC entry 2030 (class 2606 OID 24437)
-- Name: rmkms_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkms
    ADD CONSTRAINT rmkms_pkey PRIMARY KEY (id);


--
-- TOC entry 2034 (class 2606 OID 24442)
-- Name: rmkpl_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkpl
    ADD CONSTRAINT rmkpl_pkey PRIMARY KEY (id);


--
-- TOC entry 2042 (class 2606 OID 24452)
-- Name: rpjmt_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rpjmt
    ADD CONSTRAINT rpjmt_pkey PRIMARY KEY (id);


--
-- TOC entry 2044 (class 2606 OID 24457)
-- Name: rpjps_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rpjps
    ADD CONSTRAINT rpjps_pkey PRIMARY KEY (id);


--
-- TOC entry 2066 (class 2606 OID 24665)
-- Name: c_security_role_permission_id_permission_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.c_security_role_permission
    ADD CONSTRAINT c_security_role_permission_id_permission_fkey FOREIGN KEY (id_permission) REFERENCES public.c_security_permission(id);


--
-- TOC entry 2067 (class 2606 OID 24670)
-- Name: c_security_role_permission_id_role_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.c_security_role_permission
    ADD CONSTRAINT c_security_role_permission_id_role_fkey FOREIGN KEY (id_role) REFERENCES public.c_security_role(id);


--
-- TOC entry 2068 (class 2606 OID 24683)
-- Name: c_security_user_id_role_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.c_security_user
    ADD CONSTRAINT c_security_user_id_role_fkey FOREIGN KEY (id_role) REFERENCES public.c_security_role(id);


--
-- TOC entry 2069 (class 2606 OID 24693)
-- Name: c_security_user_password_id_user_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.c_security_user_password
    ADD CONSTRAINT c_security_user_password_id_user_fkey FOREIGN KEY (id_user) REFERENCES public.c_security_user(id);


--
-- TOC entry 2062 (class 2606 OID 24717)
-- Name: fk_jmkod_rpjmt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rpjps
    ADD CONSTRAINT fk_jmkod_rpjmt FOREIGN KEY (jmkod) REFERENCES public.rpjmt(jmkod) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2061 (class 2606 OID 24727)
-- Name: fk_klkod_rmkel; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rpjmt
    ADD CONSTRAINT fk_klkod_rmkel FOREIGN KEY (klkod) REFERENCES public.rmkel(klkod);


--
-- TOC entry 2064 (class 2606 OID 24742)
-- Name: fk_kmkod_rmkms; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkmj
    ADD CONSTRAINT fk_kmkod_rmkms FOREIGN KEY (kmkod) REFERENCES public.rmkms(kmkod) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2060 (class 2606 OID 24722)
-- Name: fk_kpkod_rmkpl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rpjmt
    ADD CONSTRAINT fk_kpkod_rmkpl FOREIGN KEY (kpkod) REFERENCES public.rmkpl(kpkod);


--
-- TOC entry 2059 (class 2606 OID 24732)
-- Name: fk_kpkod_rmkpl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkel
    ADD CONSTRAINT fk_kpkod_rmkpl FOREIGN KEY (klkod) REFERENCES public.rmkpl(kpkod);


--
-- TOC entry 2065 (class 2606 OID 24698)
-- Name: fkm4d87sx4kfcxn34v23i75vh91; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.c_password_reset_token
    ADD CONSTRAINT fkm4d87sx4kfcxn34v23i75vh91 FOREIGN KEY (id_user) REFERENCES public.c_security_user(id);


--
-- TOC entry 2063 (class 2606 OID 24737)
-- Name: rmkmj_jbkod_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkmj
    ADD CONSTRAINT rmkmj_jbkod_fkey FOREIGN KEY (jbkod) REFERENCES public.rmjbt(jbkod) ON UPDATE CASCADE ON DELETE RESTRICT;


-- Completed on 2019-01-27 14:55:13

--
-- PostgreSQL database dump complete
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-01-26 22:58:26

--
-- PostgreSQL database dump complete
--

