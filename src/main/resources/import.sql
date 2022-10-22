insert into usuario (usuario, tipo, senha) values ("ThiagoUser","Vendedor","123");
insert into usuario (usuario, tipo, senha) values ("FabricioUser","Recpcionista","123");
insert into usuario (usuario,tipo,  senha) values ("HugoUser","Gerente","123");

insert into cliente (nome) values ("JoãoCliente");
insert into cliente (nome) values ("PedroCliente");
insert into cliente (nome) values ("KleberCliente");

insert into categoria (descricao, nome) values ("Produto do toxico", "Fertilizantes");

insert into produto (descricao, nome, preco, categoria_id) values ("Fertmax serve para matar 9% dos germes", "Fertmax 250ml", 112.0, 1);

insert into vendedor (nome, endereco, usuario_id) values ("ThiagoVend","R. Primavera",1);
insert into vendedor (nome, endereco, usuario_id) values ("FabricioVend","R. Flores",2);
insert into vendedor (nome, endereco, usuario_id) values ("HugoVend","R. Maconha",3);