package br.edu.ufam.icomp.provex;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class ProvaDAO {
    private Context context;
    private SQLiteDatabase database;
    public ProvaDAO(Context context) {
        this.context = context;
        this.database= (new Database(context).getWritableDatabase());
    }

    public ArrayList<Prova> getList() {
        ArrayList<Prova> provasList = new ArrayList<>();
        String sql = "SELECT * FROM provas ORDER BY nome_Empresa";
        Cursor cursor = database.rawQuery(sql,null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String empresa = cursor.getString(1);
            String orgPub = cursor.getString(2);
            String estado = cursor.getString(3);
            int ano = cursor.getInt(4);
            String nivel = cursor.getString(5);
            String cargo = cursor.getString(6);
            provasList.add(new Prova(id,empresa,orgPub,estado,ano,nivel,cargo));
        }
        return provasList;
    }
    public ArrayList<String> getListCargos(){
        ArrayList<String>cargos= new ArrayList<String>();
        String sql="SELECT cargo FROM provas ORDER BY cargo";
        Cursor cursor = database.rawQuery(sql,null);

        while(cursor.moveToNext()){
            String aSer= cursor.getString(0);
            if(!cargos.contains(aSer)){
                cargos.add(aSer);
            }

        }
        return cargos;
    }
    public boolean add(Prova prova){
        String sql = "INSERT INTO provas VALUES(NULL,"
                + "'"+prova.getNomeEmpresa()+"',"
                + "'"+prova.getOrgaoPub()+"',"
                + "'"+prova.getEstado()+"',"
                + "'"+prova.getAnoProva()+"',"
                + "'"+prova.getNivel()+"',"
                + "'"+prova.getCargo()+"')";
        try{
            database.execSQL(sql);
            Toast.makeText(context,"Prova salva!",Toast.LENGTH_SHORT).show();
            return true;
        }catch (SQLException e){
            Toast.makeText(context,"Erro! "+e.getMessage(),Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    public boolean update(Prova prova){
        String sql = "UPDATE provas SET "
                +"nome_Empresa='"+prova.getNomeEmpresa()+"',"
                +"nome_OrgPub='"+prova.getOrgaoPub()+"',"
                +"nome_Estado='"+prova.getEstado()+"',"
                +"ano='"+prova.getAnoProva()+"',"
                +"nivel='"+prova.getNivel()+"',"
                +"cargo='"+prova.getCargo()+"'"
                +"WHERE id="+prova.getId();
        try {
            database.execSQL(sql);
            Toast.makeText(context,"Prova atualizada!",Toast.LENGTH_SHORT).show();
            return true;
        }catch (SQLException e){
            Toast.makeText(context,"Erro! "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    public Prova get(int Id){
        String sql = "SELECT * FROM provas WHERE id="+Id;
        Cursor cursor = database.rawQuery(sql,null);
        if(cursor.moveToNext()){
            String empresa = cursor.getString(1);
            String orgPub = cursor.getString(2);
            String estado = cursor.getString(3);
            int ano = cursor.getInt(4);
            String nivel = cursor.getString(5);
            String cargo = cursor.getString(6);
            return new Prova(Id,empresa,orgPub,estado,ano,nivel,cargo);
        }
        return null;
    }

    public boolean delete(int ID){
        String sql = "DELETE FROM provas WHERE id="+ID;
        try{
            database.execSQL(sql);
            Toast.makeText(context,"Prova deletada!",Toast.LENGTH_LONG).show();
            return true;
        }catch (SQLException e ){
            Toast.makeText(context,"Erro! "+e.getMessage(),Toast.LENGTH_LONG).show();
            return false;
        }
    }

}
