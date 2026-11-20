package biblioteca;

import java.util.Scanner;

public abstract class Usuario {
    private String nome;
    private String cpf;
    private String senha;
    private Emprestimo[] historico;
    private short prazoDias;
    private short limiteEmprestimos;

    public Usuario(String nome, String cpf, String senha, short prazoDias, short limiteEmprestimos) {
        if (nome != null && nome.length() > 0) {
            this.nome = nome;
        }
        if (cpf != null && cpf.length() == 11) {
            this.cpf = cpf;
        }
        if (senha != null && senha.length() > 0) {
            this.senha = senha;
        }
        this.prazoDias = prazoDias;
        this.limiteEmprestimos = limiteEmprestimos;
        this.historico = new Emprestimo[limiteEmprestimos];
    }

    public String getNome() { return this.nome; }

    public void setNome(String nome) {
        if (nome != null && nome.length() > 0) {
            this.nome = nome;
        }
    }

    public String getCpf() { return this.cpf; }

    public void setCpf(String cpf) {
        if (cpf != null && cpf.length() == 11) {
            this.cpf = cpf;
        }
    }

    public String getSenha() { return this.senha; }

    public void setSenha(String senha) {
        if (senha != null && senha.length() > 0) {
            this.senha = senha;
        }
    }

    public void consultarHistorico() {
        System.out.println("Historico de " + this.nome + ":");
        int quantidade = 0;
        for (int i = 0; i < this.historico.length; i++) {
            if (this.historico[i] != null) {
                System.out.println(this.historico[i]);
                quantidade++;
            }
        }
        if (quantidade == 0) {
            System.out.println("Nenhum emprestimo registrado");
        }
    }

    public void realizarEmprestimo(Livro livro) {
        int abertos = 0;
        int posicaoLivre = -1;
        for (int i = 0; i < this.historico.length; i++) {
            if (this.historico[i] != null) {
                abertos++;
            } else if (posicaoLivre == -1) {
                posicaoLivre = i;
            }
        }
        if (abertos >= getLimiteEmprestimos() || posicaoLivre == -1) {
            System.out.println(this.nome + " atingiu o limite de emprestimos");
        } else {
            Exemplar[] exemplares = livro.getExemplares();
            Exemplar disponivel = null;
            for (int i = 0; i < exemplares.length; i++) {
                if (disponivel == null && exemplares[i] != null && !exemplares[i].getReservado()) {
                    disponivel = exemplares[i];
                }
            }
            if (disponivel == null) {
                System.out.println("Nenhum exemplar disponivel");
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.print("Data do emprestimo: ");
                String data = sc.nextLine();
                disponivel.setReservado(true);
                this.historico[posicaoLivre] = new Emprestimo(posicaoLivre + 1, data, getPrazoDias() + " dias", disponivel);
                System.out.println("Emprestimo realizado para " + this.nome);
            }
        }
    }

    public void verificarEmprestimos() {
        int quantidade = 0;
        for (int i = 0; i < this.historico.length; i++) {
            if (this.historico[i] != null) {
                quantidade++;
            }
        }
        System.out.println(this.nome + ": " + quantidade + " de " + getLimiteEmprestimos() + " emprestimos em aberto");
    }

    public void quitarEmprestimo(Emprestimo emprestimo) {
        boolean encontrado = false;
        for (int i = 0; i < this.historico.length; i++) {
            if (emprestimo != null && this.historico[i] == emprestimo) {
                this.historico[i].getExemplar().setReservado(false);
                this.historico[i] = null;
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("Emprestimo quitado por " + this.nome);
        } else {
            System.out.println("Emprestimo nao encontrado para " + this.nome);
        }
    }

    public short getLimiteEmprestimos() { return this.limiteEmprestimos; }

    public short getPrazoDias() { return this.prazoDias; }
}
