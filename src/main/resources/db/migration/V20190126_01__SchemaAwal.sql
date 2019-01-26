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
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 24078)
-- Name: rmjbt; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rmjbt (
    jbkod character(3) NOT NULL,
    jbnam character varying(25)
);


ALTER TABLE public.rmjbt OWNER TO postgres;

--
-- TOC entry 2147 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN rmjbt.jbkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmjbt.jbkod IS 'Kode Jabatan';


--
-- TOC entry 2148 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN rmjbt.jbnam; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmjbt.jbnam IS 'Nama Jabatan';


--
-- TOC entry 182 (class 1259 OID 24063)
-- Name: rmkel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rmkel (
    klkod character(4) NOT NULL,
    klnam character varying(40),
    klkkk character varying(8),
    kpkod character(2)
);


ALTER TABLE public.rmkel OWNER TO postgres;

--
-- TOC entry 2149 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN rmkel.klkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkel.klkod IS 'Kode Keluarga';


--
-- TOC entry 2150 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN rmkel.klnam; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkel.klnam IS 'Nama Keluarga';


--
-- TOC entry 2151 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN rmkel.klkkk; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkel.klkkk IS 'Kode Kepala KLG';


--
-- TOC entry 2152 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN rmkel.kpkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkel.kpkod IS 'Kode Kepel';


--
-- TOC entry 186 (class 1259 OID 24086)
-- Name: rmkmj; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rmkmj (
    kmprd character varying(9) NOT NULL,
    kmkod character(3),
    kmtgl date,
    jmkod character varying(8),
    kmtgs date,
    kmakt boolean
);


ALTER TABLE public.rmkmj OWNER TO postgres;

--
-- TOC entry 2153 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rmkmj.kmtgl; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkmj.kmtgl IS 'tgl menjabat';


--
-- TOC entry 2154 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rmkmj.jmkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkmj.jmkod IS 'kode jemaat';


--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN rmkmj.kmtgs; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkmj.kmtgs IS 'tgl akhir jabat';


--
-- TOC entry 184 (class 1259 OID 24073)
-- Name: rmkms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rmkms (
    kmkod character(2) NOT NULL,
    kmnam character varying(30),
    kmsng character varying(10)
);


ALTER TABLE public.rmkms OWNER TO postgres;

--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 184
-- Name: TABLE rmkms; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.rmkms IS 'Komisi';


--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN rmkms.kmkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkms.kmkod IS 'Kode komisi';


--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN rmkms.kmnam; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkms.kmnam IS 'Nama Komisi';


--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN rmkms.kmsng; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkms.kmsng IS 'Singkatan';


--
-- TOC entry 181 (class 1259 OID 24058)
-- Name: rmkpl; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rmkpl (
    kpkod character(2) NOT NULL,
    kpnam character varying(35),
    kppnt character varying(8),
    kpdkn character varying(8)
);


ALTER TABLE public.rmkpl OWNER TO postgres;

--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 181
-- Name: TABLE rmkpl; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.rmkpl IS 'Table Kelompok Pelayanan';


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN rmkpl.kpdkn; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rmkpl.kpdkn IS 'Diaken';


--
-- TOC entry 183 (class 1259 OID 24068)
-- Name: rpjmt; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rpjmt (
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
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.jmnam; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmnam IS 'Nama Jemaat';


--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.klkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.klkod IS 'Kode Keluarga';


--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.kpkod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.kpkod IS 'Kode Kepel';


--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.jmtgl; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmtgl IS 'Tgl Lahir';


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.jmhut; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmhut IS 'Tgl-Bln Lahir';


--
-- TOC entry 2167 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.jmbpt; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmbpt IS 'Baptis';


--
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.jmsid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmsid IS 'Sidi';


--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.jmnkh; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmnkh IS 'nikah';


--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.jmkrj; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmkrj IS 'Jenis Kerja';


--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.jmpdk; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmpdk IS 'Jenis Pendidikan';


--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.jmhub; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmhub IS 'hub dgn kk';


--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN rpjmt.jmjkl; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjmt.jmjkl IS 'jns kelamin';


--
-- TOC entry 187 (class 1259 OID 24091)
-- Name: rpjps; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rpjps (
    jmkod character varying(8) NOT NULL,
    jmnam character varying(30),
    jpsid character varying(30)
);


ALTER TABLE public.rpjps OWNER TO postgres;

--
-- TOC entry 2174 (class 0 OID 0)
-- Dependencies: 187
-- Name: COLUMN rpjps.jpsid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.rpjps.jpsid IS 'Ke Sidang';


--
-- TOC entry 2135 (class 0 OID 24078)
-- Dependencies: 185
-- Data for Name: rmjbt; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rmjbt (jbkod, jbnam) FROM stdin;
\.


--
-- TOC entry 2132 (class 0 OID 24063)
-- Dependencies: 182
-- Data for Name: rmkel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rmkel (klkod, klnam, klkkk, kpkod) FROM stdin;
\.


--
-- TOC entry 2136 (class 0 OID 24086)
-- Dependencies: 186
-- Data for Name: rmkmj; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rmkmj (kmprd, kmkod, kmtgl, jmkod, kmtgs, kmakt) FROM stdin;
\.


--
-- TOC entry 2134 (class 0 OID 24073)
-- Dependencies: 184
-- Data for Name: rmkms; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rmkms (kmkod, kmnam, kmsng) FROM stdin;
\.


--
-- TOC entry 2131 (class 0 OID 24058)
-- Dependencies: 181
-- Data for Name: rmkpl; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rmkpl (kpkod, kpnam, kppnt, kpdkn) FROM stdin;
\.


--
-- TOC entry 2133 (class 0 OID 24068)
-- Dependencies: 183
-- Data for Name: rpjmt; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rpjmt (jmkod, jmnam, klkod, kpkod, jmtgl, jmhut, jmbpt, jmsid, jmnkh, jmkrj, jmpdk, kmkod, jmhub, jmjkl) FROM stdin;
\.


--
-- TOC entry 2137 (class 0 OID 24091)
-- Dependencies: 187
-- Data for Name: rpjps; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rpjps (jmkod, jmnam, jpsid) FROM stdin;
\.


--
-- TOC entry 2012 (class 2606 OID 24082)
-- Name: pk_rmjbt; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmjbt
    ADD CONSTRAINT pk_rmjbt PRIMARY KEY (jbkod);


--
-- TOC entry 2006 (class 2606 OID 24067)
-- Name: pk_rmkel; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkel
    ADD CONSTRAINT pk_rmkel PRIMARY KEY (klkod);


--
-- TOC entry 2010 (class 2606 OID 24077)
-- Name: pk_rmkms; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkms
    ADD CONSTRAINT pk_rmkms PRIMARY KEY (kmkod);


--
-- TOC entry 2004 (class 2606 OID 24062)
-- Name: pk_rmkpl; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkpl
    ADD CONSTRAINT pk_rmkpl PRIMARY KEY (kpkod);


--
-- TOC entry 2008 (class 2606 OID 24072)
-- Name: pk_rpjmt; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rpjmt
    ADD CONSTRAINT pk_rpjmt PRIMARY KEY (jmkod);


--
-- TOC entry 2016 (class 2606 OID 24095)
-- Name: pk_rtjps; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rpjps
    ADD CONSTRAINT pk_rtjps PRIMARY KEY (jmkod);


--
-- TOC entry 2014 (class 2606 OID 24090)
-- Name: pk_rtkmj; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rmkmj
    ADD CONSTRAINT pk_rtkmj PRIMARY KEY (kmprd);


--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-01-26 22:58:26

--
-- PostgreSQL database dump complete
--

