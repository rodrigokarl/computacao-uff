<?php
    $notas = array(
        "aluno1" => array(10,9,8.5),
        "aluno2" => array(7, 5.5, 6),
        "aluno3" => array(3, 4, 8),
        "aluno4" => array(1, 2.5, 3.5),
        "aluno5" => array(9, 8, 10),
    );

    function alunosAcimaMedia($notas, $indice_prova) {
        $total_notas = 0;
        $alunos = array();

        if ($indice_prova < 0 || $indice_prova >= count($notas["aluno1"])) {
            return "Índice de prova inválido";
        }

        foreach ($notas as $aluno=>$nota) {
            $total_notas += $nota[$indice_prova];
        }
        $media = $total_notas / count($notas);

        foreach ($notas as $aluno=>$nota) {
            if ($nota[$indice_prova] > $media) {
                $alunos[] = $aluno;
            }
        }
        return $alunos;
    }

    $alunos_acima_media = alunosAcimaMedia($notas, 2);
    echo "Alunos com nota acima da média na P1: \n";
    print_r($alunos_acima_media);