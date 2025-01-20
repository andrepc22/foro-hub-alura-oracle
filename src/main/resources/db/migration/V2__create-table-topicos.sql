create table topicos(
    id bigint not null auto_increment,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion datetime not null,
    status VARCHAR(100) NOT NULL,
    usuario_id bigint NOT NULL,
    curso VARCHAR(255) NOT NULL,

    primary key(id),
    constraint fk_topicos_usuarios_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)

);