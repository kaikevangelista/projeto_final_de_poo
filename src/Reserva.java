package biblioteca;

public class Reserva {
    private String data;
    private Usuario usuario;
    private Exemplar exemplar;

    public Reserva(String data, Usuario usuario, Exemplar exemplar) {
        this.data = data;
        this.usuario = usuario;
        this.exemplar = exemplar;
        exemplar.setReservado(true);
    }

    public String getData() { return this.data; }

    public Usuario getUsuario() { return this.usuario; }

    public Exemplar getExemplar() { return this.exemplar; }

    @Override
    public String toString() {
        return "Reserva de " + this.usuario.getNome() + " | Data: " + this.data + " | Exemplar: " + this.exemplar;
    }
}
