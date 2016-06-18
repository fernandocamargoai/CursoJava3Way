package br.com.threeway.locadora.domain;

public class Filme {

    private Integer codigo;
    private String titulo;
    private TipoDeFilme tipoDeFilme;

    public Filme(Integer codigo,
                 String titulo, TipoDeFilme tipoDeFilme) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.tipoDeFilme = tipoDeFilme;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoDeFilme getTipoDeFilme() {
        return tipoDeFilme;
    }

    public void setTipoDeFilme(TipoDeFilme tipoDeFilme) {
        this.tipoDeFilme = tipoDeFilme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filme filme = (Filme) o;

        if (codigo != null ? !codigo.equals(filme.codigo) : filme.codigo != null) return false;
        if (titulo != null ? !titulo.equals(filme.titulo) : filme.titulo != null) return false;
        return tipoDeFilme == filme.tipoDeFilme;

    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (tipoDeFilme != null ? tipoDeFilme.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return codigo + " - " + titulo + " - " + tipoDeFilme;
    }
}
