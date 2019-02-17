-- View: public.vjemaat

DROP VIEW public.vjemaat;

CREATE OR REPLACE VIEW public.vjemaat AS 
 SELECT rpjmt.jmkod AS "Kode",
    rpjmt.jmnam AS "Nama",
    rpjmt.jmtgl,
    rpjmt.jmhut,
        CASE rpjmt.jmbpt
            WHEN 'B'::text THEN 'BELUM'::text
            WHEN 'S'::text THEN 'SUDAH'::text
            ELSE NULL::text
        END AS baptis,
        CASE rpjmt.jmsid
            WHEN 'B'::text THEN 'BELUM'::text
            WHEN 'S'::text THEN 'SUDAH'::text
            ELSE NULL::text
        END AS sidi,
        CASE rpjmt.jmnkh
            WHEN 'M'::text THEN 'MENIKAH'::text
            WHEN 'J'::text THEN 'JANDA'::text
            WHEN 'D'::text THEN 'DUDA'::text
            WHEN 'C'::text THEN 'CERAI'::text
            WHEN 'B'::text THEN 'BELUM'::text
            ELSE NULL::text
        END AS status_pernikahan,
        CASE rpjmt.jmkrj
            WHEN 'ASN_PNS'::text THEN 'ASN-PNS'::text
            WHEN 'POLRI'::text THEN 'POLRI'::text
            WHEN 'PETANI'::text THEN 'PETANI'::text
            WHEN 'NELAYAN'::text THEN 'NELAYAN'::text
            WHEN 'KRYSWASTA'::text THEN 'KRY. SWASTA'::text
            WHEN 'WIRASWASTA'::text THEN 'WIRASWASTA'::text
            WHEN 'LAIN_LAIN'::text THEN 'LAIN LAIN'::text
            ELSE NULL::text
        END AS status_pekerjaan,
        CASE rpjmt.jmpdk
            WHEN 'S3'::text THEN 'S3'::text
            WHEN 'S2'::text THEN 'S2'::text
            WHEN 'S1'::text THEN 'S1'::text
            WHEN 'DIPLOMA'::text THEN 'DIPLOMA'::text
            WHEN 'SMA_SMK'::text THEN 'SMA-SMK'::text
            WHEN 'SMP_SD'::text THEN 'SMP-SD'::text
            WHEN 'LAIN_LAIN'::text THEN 'LAIN-LAIN'::text
            ELSE NULL::text
        END AS status_pendidikan,
        CASE rpjmt.jmhub
            WHEN 'KK'::text THEN 'KEPALA KELUARGA'::text
            WHEN 'I'::text THEN 'ISTRI'::text
            WHEN 'A'::text THEN 'ANAK'::text
            WHEN 'O'::text THEN 'ORANG TUA'::text
            WHEN 'L'::text THEN 'LAIN-LAIN'::text
            ELSE NULL::text
        END AS status_hub_kk,
        CASE rpjmt.jmjkl
            WHEN 'L'::text THEN 'LAKI-LAKI'::text
            WHEN 'P'::text THEN 'PEREMPUAN'::text
            ELSE NULL::text
        END AS status_jns_kelamin,
    rmkms.kmkod,
    rmkms.kmnam,
    rmkel.klkod,
    rmkel.klnam,
    rmkel.klkkk,
    rmkpl.kpkod,
    rmkpl.kpnam
   FROM rpjmt,
    rmkms,
    rmkel,
    rmkpl
  WHERE rpjmt.id_kmkod = rmkms.id::bpchar AND rpjmt.id_klkod = rmkel.id::bpchar AND rpjmt.id_kpkod = rmkpl.id::bpchar AND rmkpl.id::text = rmkel.id_kpkod::text;

ALTER TABLE public.vjemaat
  OWNER TO postgres;
