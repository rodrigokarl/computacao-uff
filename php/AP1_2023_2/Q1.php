<?php
    enum Iris {
        case Setosa;
        case Versicolor;
        case Virginica;
    }

    function classificaFlor($x0, $x1) {
        if ($x0 <= 2.45) {
            return Iris::Setosa;
        }
        else {
            if ($x1 <= 1.75) {
                return Iris::Versicolor;
            }
            else {
                return Iris::Virginica;
            }
        }
    }

    $teste = classificaFlor(1.4, 0.2);





