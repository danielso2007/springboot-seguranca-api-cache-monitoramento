INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$1eP5B7ewr2cToBdJG379AOG1GkR8Pm5cn.yTfXENegKyEsykegGfq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Administrador', 'admin@email.com', '$2a$10$1eP5B7ewr2cToBdJG379AOG1GkR8Pm5cn.yTfXENegKyEsykegGfq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Murilo Thales Gabriel Novaes', 'murilothalesgabrielnovaes__murilothalesgabrielnovaes@mmetalica.com.br', '$2a$10$1eP5B7ewr2cToBdJG379AOG1GkR8Pm5cn.yTfXENegKyEsykegGfq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Ruan Juan Ribeiro', 'ruanjuanribeiro__ruanjuanribeiro@lojaprincezinha.com.br', '$2a$10$1eP5B7ewr2cToBdJG379AOG1GkR8Pm5cn.yTfXENegKyEsykegGfq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Lucas Henrique Julio da Luz', 'lucashenriquejuliodaluz_@fpsgeodata.com.br', '$2a$10$1eP5B7ewr2cToBdJG379AOG1GkR8Pm5cn.yTfXENegKyEsykegGfq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Catarina Giovanna Brenda Rocha', 'ccatarinagiovannabrendarocha@mpc.com.br', '$2a$10$1eP5B7ewr2cToBdJG379AOG1GkR8Pm5cn.yTfXENegKyEsykegGfq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Nair Laura Mendes', 'nairlauramendes_@email.com', '$2a$10$1eP5B7ewr2cToBdJG379AOG1GkR8Pm5cn.yTfXENegKyEsykegGfq');

INSERT INTO PERFIL(nome) VALUES('USER');
INSERT INTO PERFIL(nome) VALUES('ADMIN');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(3,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(4,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(5,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(6,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(7,1);

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2,2);

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');
INSERT INTO CURSO(nome, categoria) VALUES('Bootstrap', 'web');
INSERT INTO CURSO(nome, categoria) VALUES('Spring RESTfull', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Spring Data', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Spring Cloud', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Spring Security', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Spring Session', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Spring HATEOAS', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Spring AMQP', 'Programação');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Tag HTML', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 2);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pretium quam eget est tincidunt, ac elementum dui ultricies.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 3);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 5', 'Nunc metus velit, ultricies sit amet nulla et, volutpat fermentum nisl.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 4);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 6', 'Suspendisse pulvinar urna nec ante facilisis rhoncus. Etiam euismod nisl sed eros placerat, eu faucibus sapien dapibus.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 5);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 7', 'Etiam eget hendrerit ipsum, vel scelerisque neque. In pulvinar odio non lacinia finibus. Sed fermentum laoreet varius. Quisque eu ultrices tellus.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 2);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 8', 'Curabitur at urna sed libero bibendum lobortis. Cras eu quam lorem. Nam interdum sollicitudin facilisis. Aenean dictum condimentum augue, et dictum ante congue et. Aliquam vitae bibendum mi, quis placerat augue. Quisque erat libero, posuere a felis non, tincidunt lacinia est.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 6);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 9', 'Praesent laoreet pulvinar tellus. Duis pharetra interdum imperdiet. ', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 6);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 10', 'Cras a enim est. In sagittis lacus a nisi convallis porttitor. Interdum et malesuada fames ac ante ipsum primis in faucibus. ', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 7);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 11', 'Morbi tristique dapibus suscipit. Sed semper eleifend lectus, ut eleifend felis egestas non.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 7);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 12', 'Integer faucibus efficitur tellus id viverra. Pellentesque eu nunc accumsan, sodales eros at, hendrerit mauris. Proin et volutpat dolor.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 7);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 13', 'Ut urna felis, pellentesque sed erat eget, iaculis congue mi.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 7);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 14', 'In eu molestie magna. Suspendisse vitae dapibus odio, eu fringilla erat. Suspendisse mauris est, malesuada posuere gravida sit amet, consectetur eget nibh.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 8);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 15', 'Quisque quam nisl, congue in malesuada sed, commodo vel tellus. Vivamus risus leo, hendrerit sed porta ac, porttitor id ex.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 8);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 16', 'Nam tempor porttitor risus sed imperdiet. Fusce lacus odio, finibus vitae purus in, efficitur luctus ligula.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 8);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 17', 'Proin mattis ex fringilla, mattis lacus quis, suscipit neque. Nunc interdum tincidunt interdum.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 9);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 18', 'Sed ornare massa lacus, pretium faucibus sem facilisis quis. Nunc ultrices dolor vel arcu pellentesque vulputate.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 9);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 19', 'Ut sed tortor placerat, iaculis sapien tristique, rutrum est. Sed feugiat dolor risus, ut efficitur nulla aliquet ac.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 9);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 20', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pretium quam eget est tincidunt, ac elementum dui ultricies. Praesent vitae purus eu elit fringilla rutrum eget ut sem.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 10);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 21', 'Duis finibus a magna in malesuada. Fusce id lectus non magna consequat congue ac vitae dolor. Integer iaculis, nibh sed feugiat iaculis, augue quam tristique elit, tincidunt auctor justo augue nec mi.', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 10);


