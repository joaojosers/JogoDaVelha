Jogo da Velha - Java 
Este é um projeto simples de Jogo da Velha desenvolvido em Java, onde dois jogadores podem competir diretamente pelo terminal. O jogo utiliza conceitos fundamentais de Programação Orientada a Objetos (POO), matrizes e lógica de repetição.

🚀 Funcionalidades

# Customização de Jogadores: O sistema solicita o nome de dois jogadores no início da partida.Tabuleiro Visual: O tabuleiro é exibido no console com índices de linha e coluna para facilitar a jogada.Lógica de Validação:Verifica se a posição escolhida está dentro dos limites do tabuleiro (0 a 2).
# Impede jogadas em casas que já foram ocupadas.Alternância de Turnos: O sistema troca automaticamente entre 'X' e 'O' após cada lance válido.Verificação de Condições de Fim de Jogo:Vitória: Identifica sequências idênticas em linhas, colunas ou diagonais.Empate: Detecta quando o tabuleiro está cheio e não há vencedores.🛠️ Como ExecutarO código está estruturado dentro do pacote org.example.Via TerminalPara compilar e executar sem uma IDE, siga estes passos:Navegue até a pasta raiz do projeto (onde está a pasta src).

# Compile o arquivo:Bashjavac src/main/java/org/example/JogoDaVelha.java -d out
(Nota: O comando acima assume a estrutura padrão Maven/Gradle. Se o arquivo estiver em uma pasta simples, ajuste o caminho).Execute o programa:Bashjava -cp out org.example.JogoDaVelha

# Via IntelliJ IDEAAbra o IntelliJ e selecione "Open".Escolha a pasta do projeto.Certifique-se de que a pasta src está marcada como "Sources Root" (botão direito na pasta > Mark Directory as > Sources Root).Localize o arquivo JogoDaVelha.java no painel de navegação lateral.Clique com o botão direito sobre o arquivo ou dentro do método main  e selecione "Run 'JogoDaVelha.main()'".O jogo iniciará no console interno da IDE.

🎮 Regras de EntradaAo jogar, o programa solicitará as coordenadas da sua jogada:Linha: Digite um número de 0 a 2 e pressione Enter.Coluna: Digite um número de 0 a 2 e pressione Enter.Exemplo de tabuleiro vazio:Plaintext        0     1     2
      -----------------
0->  |  -  |  -  |  -  |
      -----------------
1->  |  -  |  -  |  -  |
      -----------------
2->  |  -  |  -  |  -  |
      -----------------
📂 Estrutura Principal do CódigoComponenteDescriçãotabuleiroMatriz char[3][3] que armazena o estado do jogo.inicializarTabuleiro()Preenche a matriz com o caractere -.fazerJogada()Registra a escolha do jogador se for válida.verificarVitoria()Varre o tabuleiro em busca de ganhadores.main()Gerencia o fluxo principal: entrada de nomes, loop de jogadas e encerramento.
