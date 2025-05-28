<?php
    class Produto {
        private $codigo;
        private $nome;
        private $quantidade;
        private $preco;
        public function __construct($codigo, $nome, $quantidade, $preco) {
            $this->codigo = $codigo;
            $this->nome = $nome;
            $this->quantidade = $quantidade;
            $this->preco = $preco;
        }
        public function getCodigo() {
            return $this->codigo;
        }
        public function getNome() {
            return $this->nome;
        }
        public function getQuantidade() {
            return $this->quantidade;
        }
        public function getPreco() {
            return $this->preco;
        }
        public function setCodigo($codigo) {
            $this->codigo = $codigo;
        }
        public function setNome($nome) {
            $this->nome = $nome;
        }
        public function setQuantidade($quantidade) {
            $this->quantidade = quantidade;
        }
        public function setPreco($preco) {
            $this->preco = preco;
        }
        public function calcularTotal() {
            return $this->quantidade * $this->preco;
        }
    }
    $produto = new Produto(1, "produto A", 11, 5.99);
    echo "Total: " . $produto->calcularTotal() . "\n";
