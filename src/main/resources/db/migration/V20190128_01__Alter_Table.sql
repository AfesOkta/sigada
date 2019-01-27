/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Afes
 * Created: Jan 28, 2019
 */

-- Table: public.rmkel

DROP TABLE public.rmkel Cascade;

CREATE TABLE public.rmkel
(
  id character varying(255) NOT NULL,
  klkod character(4) NOT NULL, -- Kode Keluarga
  klnam character varying(40), -- Nama Keluarga
  klkkk character varying(8), -- Kode Kepala KLG
  kpkod character(2), -- Kode Kepel
  CONSTRAINT rmkel_pkey PRIMARY KEY (id),
  CONSTRAINT fk_kpkod_rmkpl FOREIGN KEY (kpkod)
      REFERENCES public.rmkpl (kpkod) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT,
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
COMMENT ON COLUMN public.rmkel.kpkod IS 'Kode Kepel';

