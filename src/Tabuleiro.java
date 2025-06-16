import java.util.Random;

public class Tabuleiro {

    private char[][] tabuleiro = new char[8][8];
    private int[] posicaoTesouro;
    private int[] posicaoJogador;
    private char jogador = 'P';
    private char blank = '-';

    public void adicionarJogador(char jogador, int linha, int coluna) {
        this.tabuleiro[encontrarJogador()[0]][encontrarJogador()[1]] = this.blank;
        this.tabuleiro[linha][coluna] = jogador;
    }

    private void adicionarTesouro() {
        Random rand = new Random();
        int linha,coluna;

        do {
            linha = rand.nextInt(8);
            coluna = rand.nextInt(8);
        } while (linha == 0 && coluna == 0);

        this.posicaoTesouro = new int[]{linha, coluna};
    }

    public int[] encontrarJogador() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == this.jogador) {
                    this.posicaoJogador = new int[]{i, j};
                    break;
                }
            }

        }
        return this.posicaoJogador;
    }

    public boolean jogoEncerrou() {
        encontrarJogador();

        boolean acertouTesouro = false;

        if (this.posicaoJogador[0] == this.posicaoTesouro[0] && this.posicaoJogador[1] == this.posicaoTesouro[1]) {
            acertouTesouro = true;
        }

        return acertouTesouro;

    }


    private void preencherTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = this.blank;
            }
        }
        this.tabuleiro[0][0] = this.jogador;
    }


    public void mostrarTabuleiro() {
        encontrarJogador();
        System.out.println(this.posicaoJogador[0] + " " + this.posicaoJogador[1]);
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }
    }

    public void iniciarTabuleiro() {
        preencherTabuleiro();
        adicionarTesouro();
    }

}
