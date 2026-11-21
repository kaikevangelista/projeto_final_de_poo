package biblioteca;

import java.util.Scanner;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private Exemplar[] exemplares;

    public Livro(String titulo, String autor, String isbn) {
        int maxExemplares = 10;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.exemplares = new Exemplar[maxExemplares];
    }

    public String getTitulo() { return this.titulo; }

    public String getAutor() { return this.autor; }

    public String getIsbn() { return this.isbn; }

    public Exemplar[] getExemplares() { return this.exemplares; }

    public void adicionarExemplar(String codigo) {
        int posicaoLivre = -1;
        boolean repetido = false;
        for (int i = 0; i < this.exemplares.length; i++) {
            if (this.exemplares[i] == null) {
                if (posicaoLivre == -1) {
                    posicaoLivre = i;
                }
            } else if (this.exemplares[i].getCodigo().equals(codigo)) {
                repetido = true;
            }
        }
        if (repetido) {
            System.out.println("Exemplar " + codigo + " ja existe em " + this.titulo);
        } else if (posicaoLivre == -1) {
            System.out.println(this.titulo + " nao tem espaco para novos exemplares");
        } else {
            this.exemplares[posicaoLivre] = new Exemplar(codigo);
            System.out.println("Exemplar " + codigo + " adicionado a " + this.titulo);
        }
    }

    public void editarExemplar(String codigo) {
        int posicao = -1;
        for (int i = 0; i < this.exemplares.length; i++) {
            if (this.exemplares[i] != null && this.exemplares[i].getCodigo().equals(codigo)) {
                posicao = i;
            }
        }
        if (posicao == -1) {
            System.out.println("Exemplar " + codigo + " nao encontrado em " + this.titulo);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Novo codigo: ");
            this.exemplares[posicao].setCodigo(sc.nextLine());
            System.out.println("Exemplar editado: " + this.exemplares[posicao]);
        }
    }

    public void removerExemplar(String codigo) {
        int posicao = -1;
        for (int i = 0; i < this.exemplares.length; i++) {
            if (this.exemplares[i] != null && this.exemplares[i].getCodigo().equals(codigo)) {
                posicao = i;
            }
        }
        if (posicao == -1) {
            System.out.println("Exemplar " + codigo + " nao encontrado em " + this.titulo);
        } else if (this.exemplares[posicao].getReservado()) {
            System.out.println("Exemplar " + codigo + " esta indisponivel e nao pode ser removido");
        } else {
            this.exemplares[posicao] = null;
            System.out.println("Exemplar " + codigo + " removido de " + this.titulo);
        }
    }

    @Override
    public String toString() {
        return this.titulo + " - " + this.autor + " | ISBN: " + this.isbn;
    }
}
