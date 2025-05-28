<?php
    class Time {
        private $resultados = array();
        private $nome;
        public function __construct($nome) {
            $this->nome = $nome;
        }
        public function insereResultados($nomeAdversario, $golsPro, $golsContra) {
            $this->resultados[$nomeAdversario] = array($golsPro, $golsContra);
        }
        public function getResultados() {
            return $this->resultados;
        }
        public function getNome() {
            return $this->nome;
        }
        public function calculaPontos() {
            $pontos = 0;
            foreach ($this->resultados as $time=>$resultado) {
                $golsPro = $resultado[0];
                $golsContra = $resultado[1];
                if ($golsPro > $golsContra) {
                    $pontos += 3;
                }
                elseif ($golsPro == $golsContra) {
                    $pontos += 1;
                }
            }
            return $pontos;
        }
    }

    class Campeonato {
        private $times = array();
        public function insereTime(Time $novoTime) {
            $this->times[] = $novoTime;
        }
        public function imprimeCampeao() {
            $maiorPontuacao = 0;
            $campeoes = array();
            foreach ($this->times as $time) {
                $pontos = $time->calculPontos();
                if ($pontos > $maiorPontuacao) {
                    $maiorPontuacao = $pontos;
                    $campeoes[] = $time->getNome();
                }
                elseif ($pontos == $maiorPontuacao) {
                    $campeoes[] = $time->getNome();
                }
            }
            echo "Campeões: " . implode(', ', $campeoes) . "\n";
        }
    }

    $time1 = new Time("Time1");
    $time2 = new Time("Time2");
    $time3 = new Time("Time3");
    $time1->insereResultados("Time2", 1, 0);
    $time1->insereResultados("Time3", 2, 1);
    $time2->insereResultados("Time1", 0, 1);
    $time2->insereResultados("Time3", 3, 2);
    $time3->insereResultados("Time1", 1, 2);
    $time3->insereResultados("Time2", 2, 3);
    $campeonato = new Campeonato();
    $campeonato->insereTime($time1);
    $campeonato->insereTime($time2);
    $campeonato->insereTime($time3);
    $campeonato->imprimeCampeao();
