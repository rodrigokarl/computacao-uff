CREATE DATABASE `sistema_vendas`;

CREATE TABLE `sistema_vendas`.`clientes`
(
    `id`            INT NOT NULL AUTO_INCREMENT,
    `nome`          VARCHAR(100) NOT NULL,
    `email`         VARCHAR(100) NOT NULL,
    `telefone`      VARCHAR(20) NOT NULL,
    `data_cadastro` DATETIME,
    PRIMARY KEY (`id`),
    UNIQUE (`email`)
);

CREATE TABLE `sistema_vendas`.`produtos`
(
    `id`            INT NOT NULL AUTO_INCREMENT,
    `nome`          VARCHAR(100) NOT NULL,
    `preco`         DECIMAL(10, 2) NOT NULL,
    `estoque`       INT NOT NULL,
    `data_cadastro` DATETIME,
    PRIMARY KEY (`id`),
    UNIQUE (`nome`)
);

CREATE TABLE `sistema_vendas`.`pedidos`
(
    `id`          INT NOT NULL AUTO_INCREMENT,
    `cliente_id`  INT NOT NULL,
    `data_pedido` DATETIME,
    `total`       DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`cliente_id`) REFERENCES `sistema_vendas`.`clientes` (`id`)
);

CREATE TABLE `sistema_vendas`.`itens_pedido`
(
    `id`             INT NOT NULL AUTO_INCREMENT,
    `pedido_id`      INT NOT NULL,
    `produto_id`     INT NOT NULL,
    `quantidade`     INT NOT NULL,
    `preco_unitario` DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`pedido_id`) REFERENCES `sistema_vendas`.`pedidos` (`id`),
    FOREIGN KEY (`produto_id`) REFERENCES `sistema_vendas`.`produtos` (`id`)
);