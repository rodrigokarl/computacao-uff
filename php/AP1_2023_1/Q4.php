<?php
    class cliente {
        private $id;
        private $nome;
        public function __construct($id, $nome) {
            $this->id = $id;
            $this->nome = $nome;
        }
        public function getId() {
            return $this->id;
        }
        public function getNome() {
            return $this->nome;
        }
    }

    class receitas {
        private $receitas;
        private $cliente;
        public function __construct($cliente) {
            $this->cliente = $cliente;
            $this->receitas = array();
        }
        public function adicionar_receita($novaReceita) {
            foreach ($this->receitas as $receita) {
                if ($receita->getTrimestre() == $novaReceita->getTrimestre()) {
                    return null;
                }
            }
            $this->receitas[] = $novaReceita;
        }
        public function getCliente() {
            return $this->cliente;
        }
        public function getReceitas() {
            return $this->receitas;
        }
        public function getSomaReceitas() {
            $soma = 0.0;
            foreach ($this->receitas as $receita) {
                $soma += $receita->getValor();
            }
            return $soma;
        }
    }

    class receita {
        private $valor;
        private $trimestre;
        public function __construct($valor, $trimestre) {
            $this->valor = $valor;
            $this->trimestre = $trimestre;
        }
        public function getValor() {
            return $this->valor;
        }
        public function getTrimestre() {
            return $this->trimestre;
        }
    }