package br.edu.ufam.icomp.provex;

public class Questao {
    private int id;
    private int provaID;
    private String Enunciado;
    private String A,B,C,D,E,F;
    private char LetraCorreta;

    public Questao(int questaoID,int idProva, String enunciado, String a, String b, String c, String d, String e, String f, char letraCorreta) {
        provaID = idProva;
        this.id = questaoID;
        Enunciado = enunciado;
        A = a;
        B = b;
        C = c;
        D = d;
        E = e;
        F = f;
        LetraCorreta = letraCorreta;
    }

    public int getQuestaoID() {
        return id;
    }

    public void setQuestaoID(int questaoID) {
        this.id = questaoID;
    }

    public int getProvaID() {
        return provaID;
    }

    public void setProvaID(int provaID) {
        this.provaID = provaID;
    }

    public String getEnunciado() {
        return Enunciado;
    }

    public void setEnunciado(String enunciado) {
        Enunciado = enunciado;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getE() {
        return E;
    }

    public void setE(String e) {
        E = e;
    }

    public String getF() {
        return F;
    }

    public void setF(String f) {
        F = f;
    }

    public char getLetraCorreta() {
        return LetraCorreta;
    }

    public void setLetraCorreta(char letraCorreta) {
        LetraCorreta = letraCorreta;
    }
    @Override
    public String toString() {
        String completa= getEnunciado()+"\n"+
                "(A) "+getA()+"\n"+
                "(B) "+getB()+"\n"+
                "(C) "+getC()+"\n"+
                "(D) "+getD()+"\n";
        if(!E.isEmpty()){
            completa+="(E) "+getE()+"\n";
            if(!F.isEmpty()){
                completa+="(F) "+getF()+"\n";
            }
        }
        completa+="\n";
        return completa;
    }
    public String previa(){
        if(getEnunciado().length()>=60){
            return getEnunciado().substring(0,60)+"...";
        }else return getEnunciado();
    }
    public String QuestaoCompleta(){
        String completa = getEnunciado()+"\n"+
                "A) "+getA()+"\n"+
                "B) "+getB()+"\n"+
                "C) "+getC()+"\n"+
                "D) "+getD();
                if(!getE().isEmpty()){
                    completa +="\nE) "+getE();
                    if(!getF().isEmpty()){
                        completa+="\nF) "+getF();
                    }
                }
        return completa;

    }
}
