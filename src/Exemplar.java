package biblioteca;

public class Exemplar {
    private String codigo;
    private boolean reservado;

    public Exemplar(String codigo) {
        if (codigo != null && codigo.length() > 0) {
            this.codigo = codigo;
        }
        this.reservado = false;
    }

    public String getCodigo() { return this.codigo; }

    public void setCodigo(String codigo) {
        if (codigo != null && codigo.length() > 0) {
            this.codigo = codigo;
        }
    }

    public boolean getReservado() { return this.reservado; }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public String toString() {
        if (this.reservado) {
            return this.codigo + " (indisponivel)";
        }
        return this.codigo + " (disponivel)";
    }
}
