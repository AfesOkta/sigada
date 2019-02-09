DROP TABLE public.rpjmt Cascade;

-- Table: public.rpjmt

-- DROP TABLE public.rpjmt;

CREATE TABLE public.rpjmt
(
  id character varying(255) NOT NULL,
  jmkod character varying(8) NOT NULL,
  jmnam character varying(30), -- Nama Jemaat
  id_kpkod character(255), -- Kode Keluarga
  id_klkod character(255), -- Kode Kepel
  jmtgl date, -- Tgl Lahir
  jmhut character varying(5), -- Tgl-Bln Lahir
  jmbpt boolean, -- Baptis
  jmsid boolean, -- Sidi
  jmnkh character varying(255), -- nikah
  jmkrj character varying(255), -- Jenis Kerja
  jmpdk character varying(255), -- Jenis Pendidikan
  id_kmkod character(255),
  jmhub character varying(255), -- hub dgn kk
  jmjkl character varying(255), -- jns kelamin
  CONSTRAINT rpjmt_pkey PRIMARY KEY (id),
  CONSTRAINT fk_kpkod_rmkpl FOREIGN KEY (id_kpkod)
      REFERENCES public.rmkpl (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_klkod_rmkel FOREIGN KEY (id_klkod)
      REFERENCES public.rmkel (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT fk_kmkod_rmkms FOREIGN KEY (id_kmkod)
      REFERENCES public.rmkms (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT jmkod_unique UNIQUE (jmkod)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.rpjmt
  OWNER TO postgres;
COMMENT ON COLUMN public.rpjmt.jmnam IS 'Nama Jemaat';
COMMENT ON COLUMN public.rpjmt.id_klkod IS 'Kode Keluarga';
COMMENT ON COLUMN public.rpjmt.id_kpkod IS 'Kode Kepel';
COMMENT ON COLUMN public.rpjmt.jmtgl IS 'Tgl Lahir';
COMMENT ON COLUMN public.rpjmt.jmhut IS 'Tgl-Bln Lahir';
COMMENT ON COLUMN public.rpjmt.jmbpt IS 'Baptis';
COMMENT ON COLUMN public.rpjmt.jmsid IS 'Sidi';
COMMENT ON COLUMN public.rpjmt.jmnkh IS 'nikah';
COMMENT ON COLUMN public.rpjmt.jmkrj IS 'Jenis Kerja';
COMMENT ON COLUMN public.rpjmt.jmpdk IS 'Jenis Pendidikan';
COMMENT ON COLUMN public.rpjmt.jmhub IS 'hub dgn kk';
COMMENT ON COLUMN public.rpjmt.jmjkl IS 'jns kelamin';

