--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2021-01-08 15:47:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 48004)
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.address (
    id_address integer NOT NULL,
    city character varying(255) NOT NULL,
    country character varying(255) NOT NULL,
    post_code character varying(255) NOT NULL,
    region character varying(255) NOT NULL,
    street_name character varying(255),
    street_number character varying(255)
);


ALTER TABLE public.address OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 48002)
-- Name: address_id_address_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.address_id_address_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.address_id_address_seq OWNER TO postgres;

--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 202
-- Name: address_id_address_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.address_id_address_seq OWNED BY public.address.id_address;


--
-- TOC entry 205 (class 1259 OID 48015)
-- Name: comment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comment (
    id_comment bigint NOT NULL,
    comment character varying(255) NOT NULL,
    publiction_date timestamp without time zone NOT NULL,
    id_spot integer,
    id_user integer
);


ALTER TABLE public.comment OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 48013)
-- Name: comment_id_comment_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comment_id_comment_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comment_id_comment_seq OWNER TO postgres;

--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 204
-- Name: comment_id_comment_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.comment_id_comment_seq OWNED BY public.comment.id_comment;


--
-- TOC entry 207 (class 1259 OID 48023)
-- Name: lenght; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lenght (
    id_lenght bigint NOT NULL,
    name character varying(255),
    cotation character varying(255),
    height real,
    id_path bigint
);


ALTER TABLE public.lenght OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 48021)
-- Name: lenght_id_lenght_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lenght_id_lenght_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lenght_id_lenght_seq OWNER TO postgres;

--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 206
-- Name: lenght_id_lenght_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lenght_id_lenght_seq OWNED BY public.lenght.id_lenght;


--
-- TOC entry 209 (class 1259 OID 48034)
-- Name: path; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.path (
    id_path bigint NOT NULL,
    cotation character varying(255) NOT NULL,
    height real NOT NULL,
    name character varying(255) NOT NULL,
    lenght_number integer,
    point_number integer,
    id_sector bigint
);


ALTER TABLE public.path OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 48032)
-- Name: path_id_path_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.path_id_path_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.path_id_path_seq OWNER TO postgres;

--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 208
-- Name: path_id_path_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.path_id_path_seq OWNED BY public.path.id_path;


--
-- TOC entry 211 (class 1259 OID 48045)
-- Name: reservation_inquiry; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation_inquiry (
    id_inquiry bigint NOT NULL,
    lend_date timestamp without time zone NOT NULL,
    statut character varying(255) NOT NULL,
    id_topo integer,
    id_user integer,
    message character varying(255)
);


ALTER TABLE public.reservation_inquiry OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 48043)
-- Name: reservation_inquiry_id_inquiry_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_inquiry_id_inquiry_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_inquiry_id_inquiry_seq OWNER TO postgres;

--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 210
-- Name: reservation_inquiry_id_inquiry_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_inquiry_id_inquiry_seq OWNED BY public.reservation_inquiry.id_inquiry;


--
-- TOC entry 212 (class 1259 OID 48051)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    code integer NOT NULL,
    label character varying(255) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 48058)
-- Name: sector; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sector (
    id_sector bigint NOT NULL,
    name character varying(255) NOT NULL,
    path_number integer NOT NULL,
    id_spot integer
);


ALTER TABLE public.sector OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 48056)
-- Name: sector_id_sector_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sector_id_sector_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sector_id_sector_seq OWNER TO postgres;

--
-- TOC entry 2925 (class 0 OID 0)
-- Dependencies: 213
-- Name: sector_id_sector_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sector_id_sector_seq OWNED BY public.sector.id_sector;


--
-- TOC entry 216 (class 1259 OID 48066)
-- Name: spot; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.spot (
    id_spot integer NOT NULL,
    niveau_difficulte character varying(255),
    name character varying(255) NOT NULL,
    nombre_voie integer,
    tag boolean,
    id_address integer
);


ALTER TABLE public.spot OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 48064)
-- Name: spot_id_spot_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.spot_id_spot_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.spot_id_spot_seq OWNER TO postgres;

--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 215
-- Name: spot_id_spot_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.spot_id_spot_seq OWNED BY public.spot.id_spot;


--
-- TOC entry 218 (class 1259 OID 48077)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id_topo integer NOT NULL,
    available boolean NOT NULL,
    description character varying(255) NOT NULL,
    location character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    publication_date timestamp without time zone NOT NULL,
    id_user integer
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 48075)
-- Name: topo_id_topo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topo_id_topo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_id_topo_seq OWNER TO postgres;

--
-- TOC entry 2927 (class 0 OID 0)
-- Dependencies: 217
-- Name: topo_id_topo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_id_topo_seq OWNED BY public.topo.id_topo;


--
-- TOC entry 220 (class 1259 OID 48088)
-- Name: user_account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_account (
    id_user integer NOT NULL,
    email character varying(255) NOT NULL,
    lastname character varying(255) NOT NULL,
    login character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    code integer
);


ALTER TABLE public.user_account OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 48086)
-- Name: user_account_id_user_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_account_id_user_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_account_id_user_seq OWNER TO postgres;

--
-- TOC entry 2928 (class 0 OID 0)
-- Dependencies: 219
-- Name: user_account_id_user_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_account_id_user_seq OWNED BY public.user_account.id_user;


--
-- TOC entry 2746 (class 2604 OID 48007)
-- Name: address id_address; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address ALTER COLUMN id_address SET DEFAULT nextval('public.address_id_address_seq'::regclass);


--
-- TOC entry 2747 (class 2604 OID 48018)
-- Name: comment id_comment; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment ALTER COLUMN id_comment SET DEFAULT nextval('public.comment_id_comment_seq'::regclass);


--
-- TOC entry 2748 (class 2604 OID 48026)
-- Name: lenght id_lenght; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lenght ALTER COLUMN id_lenght SET DEFAULT nextval('public.lenght_id_lenght_seq'::regclass);


--
-- TOC entry 2749 (class 2604 OID 48037)
-- Name: path id_path; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.path ALTER COLUMN id_path SET DEFAULT nextval('public.path_id_path_seq'::regclass);


--
-- TOC entry 2750 (class 2604 OID 48048)
-- Name: reservation_inquiry id_inquiry; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_inquiry ALTER COLUMN id_inquiry SET DEFAULT nextval('public.reservation_inquiry_id_inquiry_seq'::regclass);


--
-- TOC entry 2751 (class 2604 OID 48061)
-- Name: sector id_sector; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sector ALTER COLUMN id_sector SET DEFAULT nextval('public.sector_id_sector_seq'::regclass);


--
-- TOC entry 2752 (class 2604 OID 48069)
-- Name: spot id_spot; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot ALTER COLUMN id_spot SET DEFAULT nextval('public.spot_id_spot_seq'::regclass);


--
-- TOC entry 2753 (class 2604 OID 48080)
-- Name: topo id_topo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN id_topo SET DEFAULT nextval('public.topo_id_topo_seq'::regclass);


--
-- TOC entry 2754 (class 2604 OID 48091)
-- Name: user_account id_user; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account ALTER COLUMN id_user SET DEFAULT nextval('public.user_account_id_user_seq'::regclass);


--
-- TOC entry 2756 (class 2606 OID 48012)
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id_address);


--
-- TOC entry 2758 (class 2606 OID 48020)
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id_comment);


--
-- TOC entry 2760 (class 2606 OID 48031)
-- Name: lenght lenght_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lenght
    ADD CONSTRAINT lenght_pkey PRIMARY KEY (id_lenght);


--
-- TOC entry 2762 (class 2606 OID 48042)
-- Name: path path_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.path
    ADD CONSTRAINT path_pkey PRIMARY KEY (id_path);


--
-- TOC entry 2764 (class 2606 OID 48050)
-- Name: reservation_inquiry reservation_inquiry_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_inquiry
    ADD CONSTRAINT reservation_inquiry_pkey PRIMARY KEY (id_inquiry);


--
-- TOC entry 2766 (class 2606 OID 48055)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (code);


--
-- TOC entry 2768 (class 2606 OID 48063)
-- Name: sector sector_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sector
    ADD CONSTRAINT sector_pkey PRIMARY KEY (id_sector);


--
-- TOC entry 2770 (class 2606 OID 48074)
-- Name: spot spot_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT spot_pkey PRIMARY KEY (id_spot);


--
-- TOC entry 2772 (class 2606 OID 48085)
-- Name: topo topo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pkey PRIMARY KEY (id_topo);


--
-- TOC entry 2774 (class 2606 OID 48098)
-- Name: user_account uk_ide3ep7elgfenh6maotjnx1fp; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT uk_ide3ep7elgfenh6maotjnx1fp UNIQUE (email);


--
-- TOC entry 2776 (class 2606 OID 48100)
-- Name: user_account uk_riysyo0rs50edtynna0lfy2sr; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT uk_riysyo0rs50edtynna0lfy2sr UNIQUE (login);


--
-- TOC entry 2778 (class 2606 OID 48096)
-- Name: user_account user_account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_pkey PRIMARY KEY (id_user);


--
-- TOC entry 2788 (class 2606 OID 48146)
-- Name: user_account fk3smyef23jwfdw0at9eroajdxs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT fk3smyef23jwfdw0at9eroajdxs FOREIGN KEY (code) REFERENCES public.role(code);


--
-- TOC entry 2786 (class 2606 OID 48136)
-- Name: spot fk4rspiytwcp9vvctmoixq69lnv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT fk4rspiytwcp9vvctmoixq69lnv FOREIGN KEY (id_address) REFERENCES public.address(id_address);


--
-- TOC entry 2782 (class 2606 OID 48116)
-- Name: path fk56cl8ctd1j8meefdqiojhfty8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.path
    ADD CONSTRAINT fk56cl8ctd1j8meefdqiojhfty8 FOREIGN KEY (id_sector) REFERENCES public.sector(id_sector);


--
-- TOC entry 2787 (class 2606 OID 48141)
-- Name: topo fk62xmei2lvxddwr23g1ir6bbcr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT fk62xmei2lvxddwr23g1ir6bbcr FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);


--
-- TOC entry 2784 (class 2606 OID 48126)
-- Name: reservation_inquiry fk76fry99daivdatye4ca1em1i9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_inquiry
    ADD CONSTRAINT fk76fry99daivdatye4ca1em1i9 FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);


--
-- TOC entry 2783 (class 2606 OID 48121)
-- Name: reservation_inquiry fk8hx1lyuy19mnb1m3qjwivik6c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_inquiry
    ADD CONSTRAINT fk8hx1lyuy19mnb1m3qjwivik6c FOREIGN KEY (id_topo) REFERENCES public.topo(id_topo);


--
-- TOC entry 2779 (class 2606 OID 48101)
-- Name: comment fkh8wwu5pnwku2o30uqsltntq7l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT fkh8wwu5pnwku2o30uqsltntq7l FOREIGN KEY (id_spot) REFERENCES public.spot(id_spot);


--
-- TOC entry 2781 (class 2606 OID 48111)
-- Name: lenght fkhguro337k3tmu2d1sskst9wx8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lenght
    ADD CONSTRAINT fkhguro337k3tmu2d1sskst9wx8 FOREIGN KEY (id_path) REFERENCES public.path(id_path);


--
-- TOC entry 2780 (class 2606 OID 48106)
-- Name: comment fkif4tok3sifq3037jodfiirjfq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT fkif4tok3sifq3037jodfiirjfq FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);


--
-- TOC entry 2785 (class 2606 OID 48131)
-- Name: sector fktig1yj2lrik2rgtjkhkblupwo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sector
    ADD CONSTRAINT fktig1yj2lrik2rgtjkhkblupwo FOREIGN KEY (id_spot) REFERENCES public.spot(id_spot);


-- Completed on 2021-01-08 15:47:04

--
-- PostgreSQL database dump complete
--

