package org.example.projeto1;
import java.util.Scanner;

public class JogoDaVelha {
    private char[][] tabuleiro;   // Matriz 3x3 que representa o tabuleiro
    private char jogadorAtual;    // Guarda quem está jogando no momento (X ou O)
    private String jogador1;      // Nome do jogador que joga com X
    private String jogador2;      // Nome do jogador que joga com O

    // Contrutor: inicializa o tabuleiro e define o jogador inicial como X
    public JogoDaVelha() {
        tabuleiro = new char[3][3];
        jogadorAtual = 'X';
        inicializarTabuleiro();
    }

    // Preenche o tabuleiro com '-' (casas vazias)
    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    // Imprime o tabuleiro de forma visualmente organizada
    public void imprimeTabuleiro() {
        System.out.println("        0     1     2");
        System.out.println("      -----------------");

        for (int i = 0; i < 3; i++) {   // Indice da Linha
            System.out.print(i + "->  "); // índice da linha
            for (int j = 0; j < 3; j++) {
                System.out.print("|  " + tabuleiro[i][j] + "  ");
            }
            System.out.println("|");
            System.out.println("      -----------------");
        }
    }

    // Verifica se uma jogada é válida (dentro do tabuleiro e em casa vazia)
    public boolean jogadaValida(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3) {
            return false;
        }
        return tabuleiro[linha][coluna] == '-';
    }

    //Executa a jogada se for válida, se não mostra mensagem de erro
    public void fazerJogada(int linha, int coluna) {
        if (jogadaValida(linha, coluna)) {
            tabuleiro[linha][coluna] = jogadorAtual;
            alternajogador();   // troca para o próximo jogador
        } else {
            System.out.println("Jogada inválida, tente novamente!");
        }
    }

    // Altera o jogador atual entre X e O
    private void alternajogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    // Verfica se algum jogador venceu (linhas, colunas ou diagonais)
    public boolean verificarVitoria() {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] != '-' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return true;
            }
        }
        // Verifica colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] != '-' && tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j]) {
                return true;
            }
        }
        // Verifica diagonais
        if (tabuleiro[0][0] != '-' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return true;
        }
        if (tabuleiro[0][2] != '-' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return true;
        }
        return false;
    }

    // Verifica se houve empate (tabuleiro cheio e sem vencedor)
    public boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false;
                }
            }
        }
        return !verificarVitoria();
    }

    // Retorna quem é o jogador atual (X ou O)
    public char getJogadorAtual() {
        return jogadorAtual;
    }

    // Metodo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();

        //Pede os nomes dos jogadores
        System.out.println("Digite o nome do jogador 1 (X): ");
        jogo.jogador1 = scanner.nextLine();

        System.out.println("Digite o nome do jogador 2 (O): ");
        jogo.jogador2 = scanner.nextLine();

        // loop principal do jogo
        while (true) {
            //1. Mostra apenas o tabuleiro
            jogo.imprimeTabuleiro();    // Mostra o Tabuleiro

            //2. Mostra de quem é a vez
            String nomeAtual = (jogo.getJogadorAtual() == 'X') ? jogo.jogador1 : jogo.jogador2;
            System.out.println("\nVez de " + nomeAtual + "(" + jogo.getJogadorAtual() + ")");

            // 3. Pede a linha e coluna separados
            System.out.println("Digite a linha (0-2): ");
            int linha = scanner.nextInt();

            System.out.println("Digite a coluna (0-2): ");
            int coluna = scanner.nextInt();

            // Exexuta a jogada
            if (jogo.jogadaValida(linha, coluna)) {
                jogo.fazerJogada(linha, coluna);
            } else {
                System.out.println("Jogada inválida, tente novamente!");
                continue;
            }
            // Verifica vitória
            if (jogo.verificarVitoria()) {
                jogo.imprimeTabuleiro();
                System.out.println("\nVitória de " + nomeAtual + "!");
                break;
            }
            // Verfica empate
            if (jogo.verificarEmpate()) {
                jogo.imprimeTabuleiro();
                System.out.println("\nEmpate!");
                break;
            }
        }
        scanner.close();
    }
}

