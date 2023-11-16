
Crie um programa (em C ou Java) para simular o escalonamento de um conjunto de tarefas conhecidas (é de conhecimento o tempo de execução de cada tarefa). 

O programa deverá receber como parâmetro na linha de execução (usando argc e argv): 

    a) nome do arquivo que possui informações sobre as tarefas que serão escalonadas (cada linha do arquivo contém o nome da tarefa (identificação única), um espaço e um número inteiro que representa o tempo de execução em segundos);
    b) um número que indicará a quantidade de processadores. 
Politica de escalonamento:
    Utilize o clássico SJF (Shortest Job First) que irá executar as menores tarefas primeiro. Depois implemente o oposto, considerando o maior primeiro.
Saída:
    Como saída espera-se um arquivo contendo: id do processador e o nome de cada tarefa com o instante inicial e final (em segundos).
Exemplo:
    Forma de executar o programa: ./trabalho_escalonador tarefas.txt 2
    OBS: No arquivo de entrada: “tarefas.txt” (nome da tarefa e tempo total de execução separados pelo caractere espaço).
Por exemplo:
    Arquivo de entrada “tarefas.txt”
        a1 5
        a2 1
        a3 10
        b1 10
        b2 3
        b3 7
        b4 8
        c1 8
        c2 2

    Arquivo de saída(foi solicitado para escalonar em dois processadores e foi utilizado o SJF. Além disso, perceba que o arquivo de saída não possui espaço)
        Processador_1
            a2;0;1
            b2;1;4
            b3;4;11
            c1;11;19
            b1;19;29

        Processador_2
            c2;0;2
            a1;2;7
            b4;7;15
            a3;15;25