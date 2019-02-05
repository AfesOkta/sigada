DROP TABLE public.rmkel Cascade;

CREATE TABLE public.rmkel
(
  id character varying(255) NOT NULL,
  klkod character(4) NOT NULL, -- Kode Keluarga
  klnam character varying(40), -- Nama Keluarga
  klkkk character varying(8), -- Kode Kepala KLG  
  id_kpkod character varying(255) NOT NULL,
  CONSTRAINT rmkel_pkey PRIMARY KEY (id),
  CONSTRAINT fk_kpkod_rmkpl FOREIGN KEY (id_kpkod)
      REFERENCES public.rmkpl (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT klkod_unique UNIQUE (klkod)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.rmkel
  OWNER TO postgres;
COMMENT ON COLUMN public.rmkel.klkod IS 'Kode Keluarga';
COMMENT ON COLUMN public.rmkel.klnam IS 'Nama Keluarga';
COMMENT ON COLUMN public.rmkel.klkkk IS 'Kode Kepala KLG';
COMMENT ON COLUMN public.rmkel.id_kpkod IS 'id_kpkod';
