INSERT INTO `sistema_vendas`.`clientes` (`nome`, `email`, `telefone`, `data_cadastro`)
VALUES
    ('Maria Silva', 'maria@email.com', '21999999999', NOW()),
    ('João Souza', 'joao@email.com', '21988888888', NOW());


INSERT INTO `sistema_vendas`.`produtos` (`nome`, `preco`, `estoque`, `data_cadastro`)
VALUES
    ('Teclado', 99.90, 10, NOW()),
    ('Mouse', 49.50, 15, NOW()),
    ('Monitor', 899.00, 5, NOW());

INSERT INTO `sistema_vendas`.`pedidos` (`cliente_id`, `data_pedido`, `total`)
VALUES
    (1, NOW(), 149.40),
    (2, NOW(), 948.50);

INSERT INTO `sistema_vendas`.`itens_pedido` (`pedido_id`, `produto_id`, `quantidade`, `preco_unitario`)
VALUES
    (1, 2, 1, 46.50),
    (1, 1, 1, 99.90),
    (2, 3, 1, 899.00),
    (2, 2, 1, 49.50);