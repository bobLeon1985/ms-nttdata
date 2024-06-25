--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.26
-- Dumped by pg_dump version 9.4.26
-- Started on 2024-06-25 14:26:48

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 175 (class 1259 OID 160191)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.cliente (
    persona_id bigint NOT NULL,
    contrasena character varying(255) NOT NULL,
    estado boolean NOT NULL,
    cliente_id bigint NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 160194)
-- Name: cliente_cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_cliente_id_seq OWNER TO postgres;

--
-- TOC entry 2041 (class 0 OID 0)
-- Dependencies: 176
-- Name: cliente_cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_cliente_id_seq OWNED BY public.cliente.cliente_id;


--
-- TOC entry 178 (class 1259 OID 160209)
-- Name: cuenta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.cuenta (
    id_cuenta bigint NOT NULL,
    numero_cuenta character varying(50) NOT NULL,
    tipo_cuenta character varying(50) NOT NULL,
    saldo_inicial numeric(6,2) NOT NULL,
    estado boolean NOT NULL,
    cliente_id bigint NOT NULL
);


ALTER TABLE public.cuenta OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 160207)
-- Name: cuenta_id_cuenta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cuenta_id_cuenta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cuenta_id_cuenta_seq OWNER TO postgres;

--
-- TOC entry 2042 (class 0 OID 0)
-- Dependencies: 177
-- Name: cuenta_id_cuenta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cuenta_id_cuenta_seq OWNED BY public.cuenta.id_cuenta;


--
-- TOC entry 180 (class 1259 OID 160217)
-- Name: movimientos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.movimientos (
    id bigint NOT NULL,
    fecha timestamp with time zone NOT NULL,
    tipo_movimiento character varying(50) NOT NULL,
    valor numeric(6,2) NOT NULL,
    saldo numeric(6,2),
    id_cuenta bigint NOT NULL
);


ALTER TABLE public.movimientos OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 160215)
-- Name: movimientos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movimientos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movimientos_id_seq OWNER TO postgres;

--
-- TOC entry 2043 (class 0 OID 0)
-- Dependencies: 179
-- Name: movimientos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.movimientos_id_seq OWNED BY public.movimientos.id;


--
-- TOC entry 174 (class 1259 OID 160180)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.persona (
    id bigint NOT NULL,
    nombre character varying(255),
    genero character varying(50),
    edad integer,
    identificacion character varying(10),
    direccion character varying(256),
    telefono character varying(10)
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 160178)
-- Name: persona_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.persona_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.persona_id_seq OWNER TO postgres;

--
-- TOC entry 2044 (class 0 OID 0)
-- Dependencies: 173
-- Name: persona_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.persona_id_seq OWNED BY public.persona.id;


--
-- TOC entry 1901 (class 2604 OID 160196)
-- Name: cliente_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN cliente_id SET DEFAULT nextval('public.cliente_cliente_id_seq'::regclass);


--
-- TOC entry 1902 (class 2604 OID 160212)
-- Name: id_cuenta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta ALTER COLUMN id_cuenta SET DEFAULT nextval('public.cuenta_id_cuenta_seq'::regclass);


--
-- TOC entry 1903 (class 2604 OID 160220)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos ALTER COLUMN id SET DEFAULT nextval('public.movimientos_id_seq'::regclass);


--
-- TOC entry 1900 (class 2604 OID 160183)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona ALTER COLUMN id SET DEFAULT nextval('public.persona_id_seq'::regclass);


--
-- TOC entry 2028 (class 0 OID 160191)
-- Dependencies: 175
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (persona_id, contrasena, estado, cliente_id) FROM stdin;
1	123456	t	1
2	123456	t	2
\.


--
-- TOC entry 2045 (class 0 OID 0)
-- Dependencies: 176
-- Name: cliente_cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_cliente_id_seq', 2, true);


--
-- TOC entry 2031 (class 0 OID 160209)
-- Dependencies: 178
-- Data for Name: cuenta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cuenta (id_cuenta, numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id) FROM stdin;
2	478758	A	100.00	t	1
3	495878	A	0.00	t	2
4	495878	A	0.00	t	1
5	999999	A	0.00	t	2
6	999999	A	0.00	t	1
7	999999	A	0.00	t	1
1	225487	C	4800.00	t	1
\.


--
-- TOC entry 2046 (class 0 OID 0)
-- Dependencies: 177
-- Name: cuenta_id_cuenta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cuenta_id_cuenta_seq', 7, true);


--
-- TOC entry 2033 (class 0 OID 160217)
-- Dependencies: 180
-- Data for Name: movimientos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movimientos (id, fecha, tipo_movimiento, valor, saldo, id_cuenta) FROM stdin;
3	2024-06-25 00:00:00-05	R	100.00	10.00	1
4	2024-06-25 06:20:36-05	D	200.00	6400.00	1
5	2024-06-25 06:24:15-05	R	-200.00	6200.00	1
6	2024-06-25 06:24:56-05	R	-200.00	6000.00	1
7	2024-06-25 06:26:07-05	R	-1200.00	4800.00	1
\.


--
-- TOC entry 2047 (class 0 OID 0)
-- Dependencies: 179
-- Name: movimientos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movimientos_id_seq', 7, true);


--
-- TOC entry 2027 (class 0 OID 160180)
-- Dependencies: 174
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (id, nombre, genero, edad, identificacion, direccion, telefono) FROM stdin;
1	Jose Lema	F	34	0704379460	Otavalo sn y principal	0990593431
2	Mariela Montalvo	M	34	0100561430	Otavalo sn y principal	097548965
\.


--
-- TOC entry 2048 (class 0 OID 0)
-- Dependencies: 173
-- Name: persona_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_id_seq', 2, true);


--
-- TOC entry 1909 (class 2606 OID 160201)
-- Name: cliente_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pk PRIMARY KEY (cliente_id);


--
-- TOC entry 1911 (class 2606 OID 160214)
-- Name: cuenta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pk PRIMARY KEY (id_cuenta);


--
-- TOC entry 1913 (class 2606 OID 160222)
-- Name: movimientos_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_pk PRIMARY KEY (id);


--
-- TOC entry 1905 (class 2606 OID 160185)
-- Name: persona_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pk PRIMARY KEY (id);


--
-- TOC entry 1907 (class 2606 OID 160190)
-- Name: persona_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_unique UNIQUE (identificacion);


--
-- TOC entry 1914 (class 2606 OID 160202)
-- Name: cliente_persona_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_persona_fk FOREIGN KEY (persona_id) REFERENCES public.persona(id);


--
-- TOC entry 1915 (class 2606 OID 160228)
-- Name: cuenta_cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_cliente_fk FOREIGN KEY (cliente_id) REFERENCES public.cliente(cliente_id);


--
-- TOC entry 1916 (class 2606 OID 160223)
-- Name: movimientos_cuenta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_cuenta_fk FOREIGN KEY (id_cuenta) REFERENCES public.cuenta(id_cuenta);


--
-- TOC entry 2040 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2024-06-25 14:26:48

--
-- PostgreSQL database dump complete
--

