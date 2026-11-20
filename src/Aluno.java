package biblioteca;

public class Aluno extends Usuario {
    private String curso;
    private String matricula;

    public Aluno(String nome, String cpf, String senha, String curso, String matricula) {
        super(nome, cpf, senha, (short) 7, (short) 3);
        this.curso = curso;
        this.matricula = matricula;
    }

    public String getCurso() { return this.curso; }

    public String getMatricula() { return this.matricula; }

    @Override
    public short getLimiteEmprestimos() {
        return 3;
    }

    @Override
    public short getPrazoDias() {
        return 7;
    }
}
