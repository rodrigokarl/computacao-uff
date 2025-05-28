<?php
    class Flor {
        public $x0;
        public $x1;
        public $x2;
        public $x3;
        public function __construct($x0, $x1, $x2, $x3) {
            $this->x0 = $x0;
            $this->x1 = $x1;
            $this->x2 = $x2;
            $this->x3 = $x3;
        }
    }

    class Classifica_flor {
        public static function classifica(Flor $flor) {
            if ($flor->x0 <= 2.45) {
                return Iris::Setosa;
            }
            else {
                if ($flor->x1 <= 1.75) {
                    return Iris::Versicolor;
                }
                else {
                    return Iris::Virginica;
                }
            }
        }
        public static function exibeResultado(Flor $flor) {
            $resultado = Classifica_flor::classifica($flor);

            switch ($resultado) {
                case Iris::Setosa:
                    echo "Iris-Setosa";
                    break;
                case Iris::Versicolor:
                    echo "Iris-Versicolor";
                    break;
                case Iris::Virginica:
                    echo "Iris-Virginica";
                    break;
            }
        }
    }