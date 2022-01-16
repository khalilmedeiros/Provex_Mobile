package br.edu.ufam.icomp.provex;

public class Prova {
    private  int Id;
    private String NomeEmpresa;
    private String OrgaoPub;
    private String Estado;
    private int AnoProva;
    private String Nivel;
    private String Cargo;

    public Prova(int Id,String nomeEmpresa, String orgaoPub, String estado, int anoProva, String nivel, String cargo) {
        this.Id=Id;
        NomeEmpresa = nomeEmpresa;
        OrgaoPub = orgaoPub;
        Estado = estado;
        AnoProva = anoProva;
        Nivel = nivel;
        Cargo = cargo;


    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNomeEmpresa() {
        return NomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        NomeEmpresa = nomeEmpresa;
    }

    public String getOrgaoPub() {
        return OrgaoPub;
    }

    public void setOrgaoPub(String orgaoPub) {
        OrgaoPub = orgaoPub;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public int getAnoProva() {
        return AnoProva;
    }

    public void setAnoProva(int anoProva) {
        AnoProva = anoProva;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) {
        Nivel = nivel;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String descricaoTexto1(){
        return getNomeEmpresa()+" "+getOrgaoPub()+" "+getAnoProva();
    }

    @Override
    public String toString() {
        return "Cargo: "+getCargo()+
                "\nAno: "+getAnoProva()+
                "\nÓrgão: "+getOrgaoPub()+"/"+getEstado()+
                "\nInstituição: "+getNomeEmpresa()+
                "\nNível: "+getNivel()+"\n\n";
    }
}
