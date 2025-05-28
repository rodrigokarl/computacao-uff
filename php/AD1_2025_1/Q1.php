<?php
    abstract class ItemBiblioteca {
        private string $titulo;
        private string $autor;
        private int $anoPublicacao;
        private bool $disponivel = true;

        public function __construct($titulo, $autor, $anoPublicacao) {
            $this->titulo = $titulo;
            $this->autor = $autor;
            $this->anoPublicacao = $anoPublicacao;
        }

        public function emprestar() {
            if ($this->estaDisponivel()) {
                $this->disponivel = false;
                return true;
            }
            else {
                echo "Não foi possível emprestar. Item indisponível";
                return false;
            }
        }

        public function devolver() {
            if (!$this->estaDisponivel()) {
                $this->disponivel = true;
                return true;
            }
            else {
                echo "Não foi possível devolver. Item disponível";
                return false;
            }
        }

        public function estaDisponivel() {
            return $this->disponivel;
        }

        public function getTitulo() {
            return $this->titulo;
        }

        public function getAutor() {
            return $this->autor;
        }

        public function getAnoPublicacao() {
            return $this->anoPublicacao;
        }

        abstract public function detalhes();
    }

    class Livro extends ItemBiblioteca {
        private int $numeroPaginas;

        public function __construct($titulo, $autor, $anoPublicacao, $numeroPaginas) {
            parent::__construct($titulo, $autor, $anoPublicacao);
            $this->numeroPaginas = $numeroPaginas;
        }

        public function getNumeroPaginas() {
            return $this->numeroPaginas;
        }

        public function detalhes() {
            return "Livro: " . $this->getTitulo() . ", Autor: " . $this->getAutor() . ", Páginas: " . $this->getNumeroPaginas() . "<br>";
        }
    }

    class Revista extends ItemBiblioteca {
        private int $edicao;

        public function __construct($titulo, $autor, $anoPublicacao, $edicao) {
            parent::__construct($titulo, $autor, $anoPublicacao);
            $this->edicao = $edicao;
        }

        public function getEdicao() {
            return $this->edicao;
        }

        public function detalhes() {
            return "Revista: " . $this->getTitulo() . ", Edição: " . $this->getEdicao() . "<br>";
        }
    }

    class Usuario {
        private string $nome;
        private int $id;
        private $itensEmprestados = [];

        public function __construct($nome, $id) {
            $this->nome = $nome;
            $this->id = $id;
        }

        public function pegarEmprestado(ItemBiblioteca $item) {
            if (sizeof($this->itensEmprestados) < 3) {
                array_push($this->itensEmprestados, $item);
                $item->emprestar();
                return true;
            }
            else {
                echo "Um usuário não pode pegar mais de 3 itens simultaneamente";
                return false;
            }
        }

        public function devolverItem(ItemBiblioteca $item) {
            if (sizeof($this->itensEmprestados) > 0) {
                $indice = array_search($item, $this->itensEmprestados);
                unset($this->itensEmprestados[$indice]);
                $item->devolver();
                return true;
            }
            else {
                echo "Não existem itens para devolver";
                return false;
            }
        }

        public function getItensEmprestados() {
            $lista = [];
            foreach ($this->itensEmprestados as $item) {
                array_push($lista, $item);
            }
            return $lista;
        }
    }

    class Biblioteca {
        private $itens = [];
        private $usuarios = [];

        public function adicionarItem(ItemBiblioteca $item) {
            array_push($this->itens, $item);
        }

        public function registrarUsuario(Usuario $user) {
            array_push($this->usuarios, $user);
        }

        public function listarItensDisponiveis() {
            $lista = [];
            foreach ($this->itens as $item) {
                if ($item->estaDisponivel()) {
                    array_push($lista, $item);
                }
            }
            return $lista;
        }

        public function listarItensEmprestados() {
            $lista = [];
            foreach ($this->itens as $item) {
                if (!$item->estaDisponivel()) {
                    array_push($lista, $item);
                }
            }
            return $lista;
        }
    }


    $livro1 = new Livro("Encontro com Rama", "Arthur C Clarke", "1973", 59);
    $revista1 = new Revista("Conan, O Barbaro", "Robert E Howard", "1967", 01);
    $usuario1 = new Usuario("Rodrigo", "2079");
    $biblioteca1 = new Biblioteca();
    $biblioteca1->adicionarItem($livro1);
    $biblioteca1->adicionarItem($revista1);
    $biblioteca1->registrarUsuario($usuario1);
    $usuario1->pegarEmprestado($livro1);

    echo "Lista de itens disponíveis: <br>";
    foreach ($biblioteca1->listarItensDisponiveis() as $itemDisponivel) {
        echo $itemDisponivel->detalhes();
    }
    echo "<br>";
    echo "Lista de itens emprestados: <br>";
    foreach ($biblioteca1->listarItensEmprestados() as $itemEmprestado) {
        echo $itemEmprestado->detalhes();
    }


?>