PGDMP     4                    w            postgres    12.1    12.0 ^    �           0    0    ENCODING    ENCODING        SET client_encoding = 'BIG5';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    13318    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    2963                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            �           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    1            �            1259    17267    anais_de_conferencia    TABLE     �   CREATE TABLE public.anais_de_conferencia (
    id_anal_conf integer NOT NULL,
    id_editora integer NOT NULL,
    volume character varying(70),
    numero integer,
    data date
);
 (   DROP TABLE public.anais_de_conferencia;
       public         heap    postgres    false            �            1259    17270    artigos    TABLE     6  CREATE TABLE public.artigos (
    id_artigo integer NOT NULL,
    id_editora integer NOT NULL,
    id_livro integer,
    id_periodico integer,
    tipo_artigo character varying NOT NULL,
    titulo_artigo character varying NOT NULL,
    pg_inicial integer,
    pg_final integer,
    id_artigo_anais integer
);
    DROP TABLE public.artigos;
       public         heap    postgres    false            �            1259    17276    artigos_de_anais    TABLE     �   CREATE TABLE public.artigos_de_anais (
    id_artigo integer NOT NULL,
    titulo_congresso character varying(60),
    volume integer,
    numero integer,
    data date
);
 $   DROP TABLE public.artigos_de_anais;
       public         heap    postgres    false            �            1259    17279    artigos_de_livros    TABLE     �   CREATE TABLE public.artigos_de_livros (
    id_artigo integer NOT NULL,
    titulo_artigo character varying(60),
    num_edicao integer,
    num_cap integer,
    id_artigo_1 integer,
    ano_pub integer
);
 %   DROP TABLE public.artigos_de_livros;
       public         heap    postgres    false            �            1259    17282    artigos_de_periodicos    TABLE     �   CREATE TABLE public.artigos_de_periodicos (
    id_artigo integer NOT NULL,
    titulo_periodico integer,
    num_volume integer,
    data date
);
 )   DROP TABLE public.artigos_de_periodicos;
       public         heap    postgres    false            �            1259    17285    autores    TABLE     j   CREATE TABLE public.autores (
    id_autor integer NOT NULL,
    nome_autor character varying NOT NULL
);
    DROP TABLE public.autores;
       public         heap    postgres    false            �            1259    17291    autores_id_autor_seq    SEQUENCE     �   CREATE SEQUENCE public.autores_id_autor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.autores_id_autor_seq;
       public          postgres    false    208            �           0    0    autores_id_autor_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.autores_id_autor_seq OWNED BY public.autores.id_autor;
          public          postgres    false    209            �            1259    17293 	   capitulos    TABLE     �   CREATE TABLE public.capitulos (
    id_capitulo integer NOT NULL,
    id_livro integer NOT NULL,
    capitulo character varying(10)
);
    DROP TABLE public.capitulos;
       public         heap    postgres    false            �            1259    17296    capitulos_id_capitulo_seq    SEQUENCE     �   CREATE SEQUENCE public.capitulos_id_capitulo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.capitulos_id_capitulo_seq;
       public          postgres    false    210            �           0    0    capitulos_id_capitulo_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.capitulos_id_capitulo_seq OWNED BY public.capitulos.id_capitulo;
          public          postgres    false    211            �            1259    17298    editoras    TABLE     e   CREATE TABLE public.editoras (
    id_editora integer NOT NULL,
    editora character varying(40)
);
    DROP TABLE public.editoras;
       public         heap    postgres    false            �            1259    17301    editoras_id_editora_seq    SEQUENCE     �   CREATE SEQUENCE public.editoras_id_editora_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.editoras_id_editora_seq;
       public          postgres    false    212            �           0    0    editoras_id_editora_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.editoras_id_editora_seq OWNED BY public.editoras.id_editora;
          public          postgres    false    213            �            1259    17303 
   emprestimo    TABLE     x   CREATE TABLE public.emprestimo (
    id_emprestimo integer NOT NULL,
    publicacao_emprestimo character varying(70)
);
    DROP TABLE public.emprestimo;
       public         heap    postgres    false            �            1259    17306    emprestimo_id_emprestimo_seq    SEQUENCE     �   CREATE SEQUENCE public.emprestimo_id_emprestimo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.emprestimo_id_emprestimo_seq;
       public          postgres    false    214            �           0    0    emprestimo_id_emprestimo_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.emprestimo_id_emprestimo_seq OWNED BY public.emprestimo.id_emprestimo;
          public          postgres    false    215            �            1259    17308    livros    TABLE       CREATE TABLE public.livros (
    id_livro integer NOT NULL,
    id_editora integer NOT NULL,
    titulo character varying(60) NOT NULL,
    tipo_livro character varying(20),
    titulo_original character varying(60),
    num_edicao integer,
    ano_pub date,
    num_pag integer
);
    DROP TABLE public.livros;
       public         heap    postgres    false            �            1259    17311    monografias    TABLE     �   CREATE TABLE public.monografias (
    id_monografia integer NOT NULL,
    numero_monog integer NOT NULL,
    nome_instituicao character varying(70),
    data date
);
    DROP TABLE public.monografias;
       public         heap    postgres    false            �            1259    17314 
   periodicos    TABLE     �   CREATE TABLE public.periodicos (
    id_periodico integer NOT NULL,
    id_artigo integer NOT NULL,
    titulo character varying(70),
    volume character varying(70),
    numero integer,
    data date
);
    DROP TABLE public.periodicos;
       public         heap    postgres    false            �            1259    17317    pessoa    TABLE     �   CREATE TABLE public.pessoa (
    id_pessoa integer NOT NULL,
    nome_pessoa character varying(70),
    id_pessoa_emprestimo integer
);
    DROP TABLE public.pessoa;
       public         heap    postgres    false            �            1259    17320    pessoa_id_pessoa_seq    SEQUENCE     �   CREATE SEQUENCE public.pessoa_id_pessoa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.pessoa_id_pessoa_seq;
       public          postgres    false    219            �           0    0    pessoa_id_pessoa_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.pessoa_id_pessoa_seq OWNED BY public.pessoa.id_pessoa;
          public          postgres    false    220            �            1259    17322    publicacoes    TABLE       CREATE TABLE public.publicacoes (
    id_pub integer NOT NULL,
    tipo_publicacao character varying(20) NOT NULL,
    local_publicacao character varying NOT NULL,
    tema_publicacao character varying(50),
    titulo_publicacao character varying(50),
    id_emprestimo_pub integer
);
    DROP TABLE public.publicacoes;
       public         heap    postgres    false            �            1259    17328    publicacoes_autores    TABLE     h   CREATE TABLE public.publicacoes_autores (
    id_pub integer NOT NULL,
    id_autor integer NOT NULL
);
 '   DROP TABLE public.publicacoes_autores;
       public         heap    postgres    false            �            1259    17331    publicacoes_id_pub_seq    SEQUENCE     �   CREATE SEQUENCE public.publicacoes_id_pub_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.publicacoes_id_pub_seq;
       public          postgres    false    221            �           0    0    publicacoes_id_pub_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.publicacoes_id_pub_seq OWNED BY public.publicacoes.id_pub;
          public          postgres    false    223            �
           2604    17333    autores id_autor    DEFAULT     t   ALTER TABLE ONLY public.autores ALTER COLUMN id_autor SET DEFAULT nextval('public.autores_id_autor_seq'::regclass);
 ?   ALTER TABLE public.autores ALTER COLUMN id_autor DROP DEFAULT;
       public          postgres    false    209    208            �
           2604    17334    capitulos id_capitulo    DEFAULT     ~   ALTER TABLE ONLY public.capitulos ALTER COLUMN id_capitulo SET DEFAULT nextval('public.capitulos_id_capitulo_seq'::regclass);
 D   ALTER TABLE public.capitulos ALTER COLUMN id_capitulo DROP DEFAULT;
       public          postgres    false    211    210            �
           2604    17335    editoras id_editora    DEFAULT     z   ALTER TABLE ONLY public.editoras ALTER COLUMN id_editora SET DEFAULT nextval('public.editoras_id_editora_seq'::regclass);
 B   ALTER TABLE public.editoras ALTER COLUMN id_editora DROP DEFAULT;
       public          postgres    false    213    212            �
           2604    17336    emprestimo id_emprestimo    DEFAULT     �   ALTER TABLE ONLY public.emprestimo ALTER COLUMN id_emprestimo SET DEFAULT nextval('public.emprestimo_id_emprestimo_seq'::regclass);
 G   ALTER TABLE public.emprestimo ALTER COLUMN id_emprestimo DROP DEFAULT;
       public          postgres    false    215    214            �
           2604    17337    pessoa id_pessoa    DEFAULT     t   ALTER TABLE ONLY public.pessoa ALTER COLUMN id_pessoa SET DEFAULT nextval('public.pessoa_id_pessoa_seq'::regclass);
 ?   ALTER TABLE public.pessoa ALTER COLUMN id_pessoa DROP DEFAULT;
       public          postgres    false    220    219            �
           2604    17338    publicacoes id_pub    DEFAULT     x   ALTER TABLE ONLY public.publicacoes ALTER COLUMN id_pub SET DEFAULT nextval('public.publicacoes_id_pub_seq'::regclass);
 A   ALTER TABLE public.publicacoes ALTER COLUMN id_pub DROP DEFAULT;
       public          postgres    false    223    221            y          0    17267    anais_de_conferencia 
   TABLE DATA           ^   COPY public.anais_de_conferencia (id_anal_conf, id_editora, volume, numero, data) FROM stdin;
    public          postgres    false    203   �s       z          0    17270    artigos 
   TABLE DATA           �   COPY public.artigos (id_artigo, id_editora, id_livro, id_periodico, tipo_artigo, titulo_artigo, pg_inicial, pg_final, id_artigo_anais) FROM stdin;
    public          postgres    false    204   
t       {          0    17276    artigos_de_anais 
   TABLE DATA           ]   COPY public.artigos_de_anais (id_artigo, titulo_congresso, volume, numero, data) FROM stdin;
    public          postgres    false    205   't       |          0    17279    artigos_de_livros 
   TABLE DATA           p   COPY public.artigos_de_livros (id_artigo, titulo_artigo, num_edicao, num_cap, id_artigo_1, ano_pub) FROM stdin;
    public          postgres    false    206   Dt       }          0    17282    artigos_de_periodicos 
   TABLE DATA           ^   COPY public.artigos_de_periodicos (id_artigo, titulo_periodico, num_volume, data) FROM stdin;
    public          postgres    false    207   at       ~          0    17285    autores 
   TABLE DATA           7   COPY public.autores (id_autor, nome_autor) FROM stdin;
    public          postgres    false    208   ~t       �          0    17293 	   capitulos 
   TABLE DATA           D   COPY public.capitulos (id_capitulo, id_livro, capitulo) FROM stdin;
    public          postgres    false    210   �t       �          0    17298    editoras 
   TABLE DATA           7   COPY public.editoras (id_editora, editora) FROM stdin;
    public          postgres    false    212   �t       �          0    17303 
   emprestimo 
   TABLE DATA           J   COPY public.emprestimo (id_emprestimo, publicacao_emprestimo) FROM stdin;
    public          postgres    false    214   �t       �          0    17308    livros 
   TABLE DATA           y   COPY public.livros (id_livro, id_editora, titulo, tipo_livro, titulo_original, num_edicao, ano_pub, num_pag) FROM stdin;
    public          postgres    false    216   �t       �          0    17311    monografias 
   TABLE DATA           Z   COPY public.monografias (id_monografia, numero_monog, nome_instituicao, data) FROM stdin;
    public          postgres    false    217   u       �          0    17314 
   periodicos 
   TABLE DATA           [   COPY public.periodicos (id_periodico, id_artigo, titulo, volume, numero, data) FROM stdin;
    public          postgres    false    218   ou       �          0    17317    pessoa 
   TABLE DATA           N   COPY public.pessoa (id_pessoa, nome_pessoa, id_pessoa_emprestimo) FROM stdin;
    public          postgres    false    219   �u       �          0    17322    publicacoes 
   TABLE DATA           �   COPY public.publicacoes (id_pub, tipo_publicacao, local_publicacao, tema_publicacao, titulo_publicacao, id_emprestimo_pub) FROM stdin;
    public          postgres    false    221   �u       �          0    17328    publicacoes_autores 
   TABLE DATA           ?   COPY public.publicacoes_autores (id_pub, id_autor) FROM stdin;
    public          postgres    false    222   Fv       �           0    0    autores_id_autor_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.autores_id_autor_seq', 1, true);
          public          postgres    false    209            �           0    0    capitulos_id_capitulo_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.capitulos_id_capitulo_seq', 1, false);
          public          postgres    false    211            �           0    0    editoras_id_editora_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.editoras_id_editora_seq', 1, false);
          public          postgres    false    213            �           0    0    emprestimo_id_emprestimo_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.emprestimo_id_emprestimo_seq', 1, false);
          public          postgres    false    215            �           0    0    pessoa_id_pessoa_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.pessoa_id_pessoa_seq', 1, false);
          public          postgres    false    220            �           0    0    publicacoes_id_pub_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.publicacoes_id_pub_seq', 8, true);
          public          postgres    false    223            �
           2606    17340 .   anais_de_conferencia anais_de_conferencia_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public.anais_de_conferencia
    ADD CONSTRAINT anais_de_conferencia_pkey PRIMARY KEY (id_anal_conf);
 X   ALTER TABLE ONLY public.anais_de_conferencia DROP CONSTRAINT anais_de_conferencia_pkey;
       public            postgres    false    203            �
           2606    17342 %   artigos_de_anais artigo_de_anais_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.artigos_de_anais
    ADD CONSTRAINT artigo_de_anais_pkey PRIMARY KEY (id_artigo);
 O   ALTER TABLE ONLY public.artigos_de_anais DROP CONSTRAINT artigo_de_anais_pkey;
       public            postgres    false    205            �
           2606    17344 (   artigos_de_livros artigo_de_livros__pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.artigos_de_livros
    ADD CONSTRAINT artigo_de_livros__pkey PRIMARY KEY (id_artigo);
 R   ALTER TABLE ONLY public.artigos_de_livros DROP CONSTRAINT artigo_de_livros__pkey;
       public            postgres    false    206            �
           2606    17346 .   artigos_de_periodicos artigo_de_periodico_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY public.artigos_de_periodicos
    ADD CONSTRAINT artigo_de_periodico_pkey PRIMARY KEY (id_artigo);
 X   ALTER TABLE ONLY public.artigos_de_periodicos DROP CONSTRAINT artigo_de_periodico_pkey;
       public            postgres    false    207            �
           2606    17348    artigos artigos__pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.artigos
    ADD CONSTRAINT artigos__pkey PRIMARY KEY (id_artigo);
 ?   ALTER TABLE ONLY public.artigos DROP CONSTRAINT artigos__pkey;
       public            postgres    false    204            �
           2606    17350    autores autor_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.autores
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id_autor);
 <   ALTER TABLE ONLY public.autores DROP CONSTRAINT autor_pkey;
       public            postgres    false    208            �
           2606    17352    capitulos capitulo_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.capitulos
    ADD CONSTRAINT capitulo_pkey PRIMARY KEY (id_capitulo, id_livro);
 A   ALTER TABLE ONLY public.capitulos DROP CONSTRAINT capitulo_pkey;
       public            postgres    false    210    210            �
           2606    17354    editoras editora_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.editoras
    ADD CONSTRAINT editora_pkey PRIMARY KEY (id_editora);
 ?   ALTER TABLE ONLY public.editoras DROP CONSTRAINT editora_pkey;
       public            postgres    false    212            �
           2606    17356    emprestimo emprestimo_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT emprestimo_pkey PRIMARY KEY (id_emprestimo);
 D   ALTER TABLE ONLY public.emprestimo DROP CONSTRAINT emprestimo_pkey;
       public            postgres    false    214            �
           2606    17358    publicacoes_autores id_autor 
   CONSTRAINT     h   ALTER TABLE ONLY public.publicacoes_autores
    ADD CONSTRAINT id_autor PRIMARY KEY (id_pub, id_autor);
 F   ALTER TABLE ONLY public.publicacoes_autores DROP CONSTRAINT id_autor;
       public            postgres    false    222    222            �
           2606    17360    livros livro_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.livros
    ADD CONSTRAINT livro_pkey PRIMARY KEY (id_livro);
 ;   ALTER TABLE ONLY public.livros DROP CONSTRAINT livro_pkey;
       public            postgres    false    216            �
           2606    17362    monografias monografias_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.monografias
    ADD CONSTRAINT monografias_pkey PRIMARY KEY (id_monografia);
 F   ALTER TABLE ONLY public.monografias DROP CONSTRAINT monografias_pkey;
       public            postgres    false    217            �
           2606    17364    periodicos periodicos_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.periodicos
    ADD CONSTRAINT periodicos_pkey PRIMARY KEY (id_periodico);
 D   ALTER TABLE ONLY public.periodicos DROP CONSTRAINT periodicos_pkey;
       public            postgres    false    218            �
           2606    17366    pessoa pessoa_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id_pessoa);
 <   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_pkey;
       public            postgres    false    219            �
           2606    17368    publicacoes publicacoes_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.publicacoes
    ADD CONSTRAINT publicacoes_pkey PRIMARY KEY (id_pub);
 F   ALTER TABLE ONLY public.publicacoes DROP CONSTRAINT publicacoes_pkey;
       public            postgres    false    221            �
           2606    17369 &   artigos artigo_de_periodico_artigos_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.artigos
    ADD CONSTRAINT artigo_de_periodico_artigos_fk FOREIGN KEY (id_artigo) REFERENCES public.artigos_de_periodicos(id_artigo);
 P   ALTER TABLE ONLY public.artigos DROP CONSTRAINT artigo_de_periodico_artigos_fk;
       public          postgres    false    207    204    2772            �
           2606    17374 .   artigos_de_livros artigos__artigo_de_livros_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.artigos_de_livros
    ADD CONSTRAINT artigos__artigo_de_livros_fk FOREIGN KEY (id_artigo) REFERENCES public.artigos(id_artigo);
 X   ALTER TABLE ONLY public.artigos_de_livros DROP CONSTRAINT artigos__artigo_de_livros_fk;
       public          postgres    false    204    206    2766            �
           2606    17379 -   artigos_de_anais artigos__artigos_de_anais_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.artigos_de_anais
    ADD CONSTRAINT artigos__artigos_de_anais_fk FOREIGN KEY (id_artigo) REFERENCES public.artigos(id_artigo);
 W   ALTER TABLE ONLY public.artigos_de_anais DROP CONSTRAINT artigos__artigos_de_anais_fk;
       public          postgres    false    2766    204    205            �
           2606    17384 1   publicacoes_autores autores_publicacao_autores_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.publicacoes_autores
    ADD CONSTRAINT autores_publicacao_autores_fk FOREIGN KEY (id_autor) REFERENCES public.autores(id_autor);
 [   ALTER TABLE ONLY public.publicacoes_autores DROP CONSTRAINT autores_publicacao_autores_fk;
       public          postgres    false    222    208    2774            �
           2606    17389 4   anais_de_conferencia editora_anais_de_conferencia_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.anais_de_conferencia
    ADD CONSTRAINT editora_anais_de_conferencia_fk FOREIGN KEY (id_editora) REFERENCES public.editoras(id_editora);
 ^   ALTER TABLE ONLY public.anais_de_conferencia DROP CONSTRAINT editora_anais_de_conferencia_fk;
       public          postgres    false    2778    212    203            �
           2606    17394    artigos editora_artigos_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.artigos
    ADD CONSTRAINT editora_artigos_fk FOREIGN KEY (id_editora) REFERENCES public.editoras(id_editora);
 D   ALTER TABLE ONLY public.artigos DROP CONSTRAINT editora_artigos_fk;
       public          postgres    false    204    212    2778            �
           2606    17399    livros editora_livros_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.livros
    ADD CONSTRAINT editora_livros_fk FOREIGN KEY (id_editora) REFERENCES public.editoras(id_editora);
 B   ALTER TABLE ONLY public.livros DROP CONSTRAINT editora_livros_fk;
       public          postgres    false    212    216    2778            �
           2606    17404    artigos fk_id_artigo_anais    FK CONSTRAINT     �   ALTER TABLE ONLY public.artigos
    ADD CONSTRAINT fk_id_artigo_anais FOREIGN KEY (id_artigo_anais) REFERENCES public.anais_de_conferencia(id_anal_conf);
 D   ALTER TABLE ONLY public.artigos DROP CONSTRAINT fk_id_artigo_anais;
       public          postgres    false    204    2764    203            �
           2606    17409     publicacoes fk_id_emprestimo_pub    FK CONSTRAINT     �   ALTER TABLE ONLY public.publicacoes
    ADD CONSTRAINT fk_id_emprestimo_pub FOREIGN KEY (id_emprestimo_pub) REFERENCES public.emprestimo(id_emprestimo);
 J   ALTER TABLE ONLY public.publicacoes DROP CONSTRAINT fk_id_emprestimo_pub;
       public          postgres    false    221    214    2780            �
           2606    17414    pessoa fk_id_pessoa_emprestimo    FK CONSTRAINT     �   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT fk_id_pessoa_emprestimo FOREIGN KEY (id_pessoa_emprestimo) REFERENCES public.emprestimo(id_emprestimo);
 H   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT fk_id_pessoa_emprestimo;
       public          postgres    false    214    219    2780            �
           2606    17419    capitulos livro_capitulo_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.capitulos
    ADD CONSTRAINT livro_capitulo_fk FOREIGN KEY (id_livro) REFERENCES public.livros(id_livro);
 E   ALTER TABLE ONLY public.capitulos DROP CONSTRAINT livro_capitulo_fk;
       public          postgres    false    2782    210    216            �
           2606    17424    artigos livros_artigos__fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.artigos
    ADD CONSTRAINT livros_artigos__fk FOREIGN KEY (id_livro) REFERENCES public.livros(id_livro);
 D   ALTER TABLE ONLY public.artigos DROP CONSTRAINT livros_artigos__fk;
       public          postgres    false    204    216    2782            �
           2606    17429    artigos periodicos_artigos_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.artigos
    ADD CONSTRAINT periodicos_artigos_fk FOREIGN KEY (id_periodico) REFERENCES public.periodicos(id_periodico);
 G   ALTER TABLE ONLY public.artigos DROP CONSTRAINT periodicos_artigos_fk;
       public          postgres    false    218    2786    204            �
           2606    17434 8   anais_de_conferencia publicacoes_anais_de_conferencia_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.anais_de_conferencia
    ADD CONSTRAINT publicacoes_anais_de_conferencia_fk FOREIGN KEY (id_anal_conf) REFERENCES public.publicacoes(id_pub);
 b   ALTER TABLE ONLY public.anais_de_conferencia DROP CONSTRAINT publicacoes_anais_de_conferencia_fk;
       public          postgres    false    203    2790    221            �
           2606    17439    livros publicacoes_livro_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.livros
    ADD CONSTRAINT publicacoes_livro_fk FOREIGN KEY (id_livro) REFERENCES public.publicacoes(id_pub);
 E   ALTER TABLE ONLY public.livros DROP CONSTRAINT publicacoes_livro_fk;
       public          postgres    false    216    221    2790            �
           2606    17444 &   monografias publicacoes_monografias_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.monografias
    ADD CONSTRAINT publicacoes_monografias_fk FOREIGN KEY (id_monografia) REFERENCES public.publicacoes(id_pub);
 P   ALTER TABLE ONLY public.monografias DROP CONSTRAINT publicacoes_monografias_fk;
       public          postgres    false    2790    221    217            �
           2606    17449 $   periodicos publicacoes_periodicos_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.periodicos
    ADD CONSTRAINT publicacoes_periodicos_fk FOREIGN KEY (id_periodico) REFERENCES public.publicacoes(id_pub);
 N   ALTER TABLE ONLY public.periodicos DROP CONSTRAINT publicacoes_periodicos_fk;
       public          postgres    false    2790    218    221            �
           2606    17454 5   publicacoes_autores publicacoes_publicacao_autores_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.publicacoes_autores
    ADD CONSTRAINT publicacoes_publicacao_autores_fk FOREIGN KEY (id_pub) REFERENCES public.publicacoes(id_pub);
 _   ALTER TABLE ONLY public.publicacoes_autores DROP CONSTRAINT publicacoes_publicacao_autores_fk;
       public          postgres    false    2790    222    221            y      x������ � �      z      x������ � �      {      x������ � �      |      x������ � �      }      x������ � �      ~      x�3���/�L,����� �V      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   G   x�3�464�����2A��9F������F�\朆FƜ%���%����2���Ɔ�!����1z\\\ �      �      x������ � �      �      x������ � �      �   �   x���=�0��9EN�����T	!����S�R���H3X����$ʐ����'SB�4M9��v-�'��c�:��c�:����$�q*y|��f/�����7ϢtG0��)�.�#�vg{�Q��c/R���O�_�e�_c~��d�      �      x�3�4����� o      