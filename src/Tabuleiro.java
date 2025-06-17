import java.util.Random;

public class Tabuleiro {

    private char[][] tabuleiro = new char[8][8];
    private int[] posicaoTesouro;

    private int jogadorLinha = 0;
    private int jogadorColuna = 0;

    private char jogador = 'P';
    private char blank = '-';
    private char tesouro = 'T';

    private boolean encontrouTesouro = false;

    private int qtdTentativas = 0;

    public void movimentacaoJogador(String direcao) {

        this.tabuleiro[this.jogadorLinha][this.jogadorColuna] = this.blank;

        switch (direcao) {
            case "ACIMA":
                if(this.jogadorLinha == 0) {
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
                }
                this.jogadorLinha--;
                this.qtdTentativas++;
                break;
            case "ABAIXO":
                if(this.jogadorLinha == 7) {
                    System.out.println("POSIÇÃO INVÁLIDA!");
                    break;
                }
                this.jogadorLinha++;
                this.qtdTentativas++;
                break;
            case "DIREITA":
                if(this.jogadorColuna == 7) {
                    System.out.println("POSIÇÃO INVÁLIDA");
                    break;
                }
                this.jogadorColuna++;
                this.qtdTentativas++;
                break;
            case "ESQUERDA":
                if(this.jogadorColuna == 0) {
                    System.out.println("POSIÇÃO INVÁLIDA");
                    break;
                }
                this.jogadorColuna--;
                this.qtdTentativas++;
                break;
            default:
                System.out.println("NÃO EXISTE ESSA DIREÇÃO");
                break;
        }

        this.tabuleiro[this.jogadorLinha][this.jogadorColuna] = this.jogador;

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

    public boolean jogoEncerrou() {

        if (this.jogadorLinha == this.posicaoTesouro[0] && this.jogadorColuna == this.posicaoTesouro[1]) {
            this.encontrouTesouro = true;
            this.tabuleiro[this.posicaoTesouro[0]][this.posicaoTesouro[1]] = this.tesouro;
        }

        return this.encontrouTesouro;
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

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void iniciarTabuleiro() {
        preencherTabuleiro();
        adicionarTesouro();
    }

    public int qtdTentativas() {
        return qtdTentativas;
    }


}
