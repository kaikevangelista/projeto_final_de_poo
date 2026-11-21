

public class Professor extends Usuario {
    private String departamento;
    private String formacao;

    public Professor(String nome, String cpf, String senha, String departamento, String formacao) {
        super(nome, cpf, senha, (short) 14, (short) 5);
        this.departamento = departamento;
        this.formacao = formacao;
    }

    public String getDepartamento() { return this.departamento; }

    public String getFormacao() { return this.formacao; }

    @Override
    public short getLimiteEmprestimos() {
        return 5;
    }

    @Override
    public short getPrazoDias() {
        return 14;
    }
}
