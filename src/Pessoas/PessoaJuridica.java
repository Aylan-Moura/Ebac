package Pessoas;

public class PessoaJuridica extends Pessoa{
private String cnpj;
private String razaosocial;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public PessoaJuridica(String nome, String endereco, String cnpj, String razaosocial) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.razaosocial = razaosocial;
    }

    @Override
    public void exibirDados() {
        System.out.println("Pessoa Juridica");
        System.out.println("Nome Fantasia: " + getNome());
        System.out.println("Endereco: " + getEndereco());
        System.out.println("CNPJ: " + cnpj );
        System.out.println("Razão Social: " + razaosocial);

    }
}
