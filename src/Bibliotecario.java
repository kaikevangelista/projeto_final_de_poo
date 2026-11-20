package biblioteca;

public class Bibliotecario extends Usuario {

    public Bibliotecario(String nome, String cpf, String senha) {
        super(nome, cpf, senha, (short) 7, (short) 3);
    }

    public void cadastrarLivro() {
        System.out.println(getNome() + " cadastrou um livro");
    }

    public void editarLivro() {
        System.out.println(getNome() + " editou um livro");
    }

    public void removerLivro() {
        System.out.println(getNome() + " removeu um livro");
    }

    public void cadastrarAluno() {
        System.out.println(getNome() + " cadastrou um aluno");
    }

    public void editarAluno() {
        System.out.println(getNome() + " editou um aluno");
    }

    public void removerAluno() {
        System.out.println(getNome() + " removeu um aluno");
    }

    public void removerProfessor() {
        System.out.println(getNome() + " removeu um professor");
    }

    public void editarProfessor() {
        System.out.println(getNome() + " editou um professor");
    }

    public void cadastrarProfessor() {
        System.out.println(getNome() + " cadastrou um professor");
    }
}
