package biblioteca;

public class Emprestimo {
    private int id;
    private String data;
    private String prazo;
    private Exemplar exemplar;

    public Emprestimo(int id, String data, String prazo, Exemplar exemplar) {
        this.id = id;
        this.data = data;
        this.prazo = prazo;
        this.exemplar = exemplar;
    }

    public int getId() { return this.id; }

    public String getData() { return this.data; }

    public String getPrazo() { return this.prazo; }

    public Exemplar getExemplar() { return this.exemplar; }

    @Override
    public String toString() {
        return "Emprestimo " + this.id + " | Data: " + this.data + " | Prazo: " + this.prazo + " | Exemplar: " + this.exemplar;
    }
}
