public class Jogador {

    private char jogador = 'P';
    private Tabuleiro tabuleiro;

    public Jogador(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void andar(String direcao) {
        int[] posicaoJogador = this.tabuleiro.encontrarJogador();

        switch (direcao.toUpperCase()) {
            case "ACIMA":
                if(posicaoJogador[0] == 0) {
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
                }
                posicaoJogador[0]--;
                break;
            case "ABAIXO":
                if(posicaoJogador[0] == 7) {
                    System.out.println("POSIÇÃO INVÁLIDA!");
                    break;
                }
                posicaoJogador[0]++;
                break;
            case "DIREITA":
                if(posicaoJogador[1] == 7) {
                    System.out.println("POSIÇÃO INVÁLIDA");
                    break;
                }
                posicaoJogador[1]++;
                break;
            case "ESQUERDA":
                if(posicaoJogador[1] == 0) {
                    System.out.println("POSIÇÃO INVÁLIDA");
                    break;
                }
                posicaoJogador[1]--;
                break;
            default:
                System.out.println("NÃO EXISTE ESSA DIREÇÃO");
                break;
        }

        int linha = posicaoJogador[0];
        int coluna = posicaoJogador[1];
        this.tabuleiro.adicionarJogador(this.jogador, linha, coluna);


    }


}
