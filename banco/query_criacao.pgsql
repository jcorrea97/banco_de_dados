
CREATE TABLE public.artigos_de_periodicos (
                id_artigo INTEGER NOT NULL,
                titulo_periodico INTEGER,
                num_volume INTEGER,
                data DATE,
                CONSTRAINT artigo_de_periodico_pkey PRIMARY KEY (id_artigo)
);


CREATE TABLE public.autores (
                id_autor SERIAL,
                nome_autor VARCHAR NOT NULL,
                CONSTRAINT autor_pkey PRIMARY KEY (id_autor)
);


CREATE TABLE public.publicacoes (
                id_pub SERIAL,
                tipo_publicacao VARCHAR(20) NOT NULL,
                local_publicacao VARCHAR NOT NULL,
                CONSTRAINT publicacoes_pkey PRIMARY KEY (id_pub)
);


CREATE TABLE public.periodicos (
                id_periodico INTEGER NOT NULL,
                id_artigo INTEGER NOT NULL,
                titulo VARCHAR(70),
                volume VARCHAR(70),
                numero INTEGER,
                data DATE,
                CONSTRAINT periodicos_pkey PRIMARY KEY (id_periodico)
);


CREATE TABLE public.publicacoes_autores (
                id_pub INTEGER NOT NULL,
                id_autor INTEGER NOT NULL,
                CONSTRAINT id_autor PRIMARY KEY (id_pub, id_autor)
);


CREATE TABLE public.monografias (
                id_monografia INTEGER NOT NULL,
                numero_monog INTEGER NOT NULL,
                nome_instituicao VARCHAR(70),
                data DATE,
                titulo VARCHAR(60) NOT NULL,
                CONSTRAINT monografias_pkey PRIMARY KEY (id_monografia)
);


CREATE TABLE public.editoras (
                id_editora SERIAL,
                Editora VARCHAR(40),
                CONSTRAINT editora_pkey PRIMARY KEY (id_editora)
);


CREATE TABLE public.livros (
                id_livro INTEGER NOT NULL,
                id_editora INTEGER NOT NULL,
                titulo VARCHAR(60) NOT NULL,
                tipo_livro VARCHAR(20),
                titulo_original VARCHAR(60),
                num_edicao INTEGER,
                ano_pub DATE,
                num_pag INTEGER,
                CONSTRAINT livro_pkey PRIMARY KEY (id_livro)
);


CREATE TABLE public.artigos (
                id_artigo INTEGER NOT NULL,
                id_editora INTEGER NOT NULL,
                id_livro INTEGER,
                id_periodico INTEGER,
                tipo_artigo VARCHAR NOT NULL,
                titulo_artigo VARCHAR NOT NULL,
                pg_inicial INTEGER,
                pg_final INTEGER,
                CONSTRAINT artigos__pkey PRIMARY KEY (id_artigo)
);


CREATE TABLE public.artigos_de_livros (
                id_artigo INTEGER NOT NULL,
                titulo_artigo VARCHAR(60),
                num_edicao INTEGER,
                num_cap INTEGER,
                id_artigo_1 INTEGER,
                ano_pub INTEGER,
                CONSTRAINT artigo_de_livros__pkey PRIMARY KEY (id_artigo)
);


CREATE TABLE public.artigos_de_anais (
                id_artigo INTEGER NOT NULL,
                titulo_congresso VARCHAR(60),
                volume INTEGER,
                numero INTEGER,
                data DATE,
                CONSTRAINT artigo_de_anais_pkey PRIMARY KEY (id_artigo)
);


CREATE TABLE public.anais_de_conferencia (
                id_anal_conf INTEGER NOT NULL,
                id_editora INTEGER NOT NULL,
                volume VARCHAR(70),
                numero INTEGER,
                data DATE,
                CONSTRAINT anais_de_conferencia_pkey PRIMARY KEY (id_anal_conf)
);


CREATE TABLE public.capitulos (
                id_capitulo SERIAL,
                id_livro INTEGER NOT NULL,
                capitulo VARCHAR(10),
                CONSTRAINT capitulo_pkey PRIMARY KEY (id_capitulo, id_livro)
);


ALTER TABLE public.artigos ADD CONSTRAINT artigo_de_periodico_artigos_fk
FOREIGN KEY (id_artigo)
REFERENCES public.artigos_de_periodicos (id_artigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.publicacoes_autores ADD CONSTRAINT autores_publicacao_autores_fk
FOREIGN KEY (id_autor)
REFERENCES public.autores (id_autor)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.anais_de_conferencia ADD CONSTRAINT publicacoes_anais_de_conferencia_fk
FOREIGN KEY (id_anal_conf)
REFERENCES public.publicacoes (id_pub)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.monografias ADD CONSTRAINT publicacoes_monografias_fk
FOREIGN KEY (id_monografia)
REFERENCES public.publicacoes (id_pub)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.livros ADD CONSTRAINT publicacoes_livro_fk
FOREIGN KEY (id_livro)
REFERENCES public.publicacoes (id_pub)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.publicacoes_autores ADD CONSTRAINT publicacoes_publicacao_autores_fk
FOREIGN KEY (id_pub)
REFERENCES public.publicacoes (id_pub)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.periodicos ADD CONSTRAINT publicacoes_periodicos_fk
FOREIGN KEY (id_periodico)
REFERENCES public.publicacoes (id_pub)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.artigos ADD CONSTRAINT periodicos_artigos_fk
FOREIGN KEY (id_periodico)
REFERENCES public.periodicos (id_periodico)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.anais_de_conferencia ADD CONSTRAINT editora_anais_de_conferencia_fk
FOREIGN KEY (id_editora)
REFERENCES public.editoras (id_editora)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.livros ADD CONSTRAINT editora_livros_fk
FOREIGN KEY (id_editora)
REFERENCES public.editoras (id_editora)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.artigos ADD CONSTRAINT editora_artigos_fk
FOREIGN KEY (id_editora)
REFERENCES public.editoras (id_editora)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.capitulos ADD CONSTRAINT livro_capitulo_fk
FOREIGN KEY (id_livro)
REFERENCES public.livros (id_livro)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.artigos ADD CONSTRAINT livros_artigos__fk
FOREIGN KEY (id_livro)
REFERENCES public.livros (id_livro)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.artigos_de_anais ADD CONSTRAINT artigos__artigos_de_anais_fk
FOREIGN KEY (id_artigo)
REFERENCES public.artigos (id_artigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.artigos_de_livros ADD CONSTRAINT artigos__artigo_de_livros_fk
FOREIGN KEY (id_artigo)
REFERENCES public.artigos (id_artigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
