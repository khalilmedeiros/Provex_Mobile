package br.edu.ufam.icomp.provex;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestaoDAO {
    private Context context;
    private SQLiteDatabase database;
    public QuestaoDAO(Context context) {
        this.context = context;
        this.database= (new Database(context).getWritableDatabase());
    }

    public ArrayList<Questao> getList(int provaID){
        ArrayList<Questao> questoesList = new ArrayList<>();
        String sql = "SELECT * FROM questoes WHERE provaID="+provaID;
        Cursor cursor = database.rawQuery(sql,null);
        while(cursor.moveToNext()){
            int questaoID = cursor.getInt(0);
            int provaId =cursor.getInt(1);
            String enunciado = cursor.getString(2);
            String altA= cursor.getString(3);
            String altB=cursor.getString(4);
            String altC=cursor.getString(5);
            String altD=cursor.getString(6);
            String altE=cursor.getString(7);
            String altF=cursor.getString(8);
            char altCorreta=cursor.getString(9).charAt(0);
            questoesList.add(new Questao(questaoID,provaId,enunciado,altA,altB,altC,altD,altE,altF,altCorreta));
        }
        return questoesList;
    }
    public boolean add(Questao questao){
        String sql = "INSERT INTO questoes VALUES(NULL,"
                + "'"+questao.getProvaID()+"',"
                + "'"+questao.getEnunciado()+"',"
                + "'"+questao.getA()+"',"
                + "'"+questao.getB()+"',"
                + "'"+questao.getC()+"',"
                + "'"+questao.getD()+"',"
                + "'"+questao.getE()+"',"
                + "'"+questao.getF()+"',"
                + "'"+questao.getLetraCorreta()+"')";
        try{
            database.execSQL(sql);
            Toast.makeText(context,"Prova salva!",Toast.LENGTH_SHORT).show();
            return true;
        }catch (SQLException e){
            Toast.makeText(context,"Erro! "+e.getMessage(),Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean update(Questao questao){
        String sql = "UPDATE questoes SET "
                +"enunciado='"+questao.getEnunciado()+"',"
                +"AltA='"+questao.getA()+"',"
                +"AltB='"+questao.getB()+"',"
                +"AltC='"+questao.getC()+"',"
                +"AltD='"+questao.getD()+"',"
                +"AltE='"+questao.getE()+"',"
                +"AltF='"+questao.getF()+"',"
                +"AltCorreta='"+questao.getLetraCorreta()+"'"
                +"WHERE id="+questao.getQuestaoID();
        try {
            database.execSQL(sql);
            Toast.makeText(context,"Prova atualizada!",Toast.LENGTH_SHORT).show();
            return true;
        }catch (SQLException e){
            Toast.makeText(context,"Erro! "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public Questao get(int id){
        String sql = "SELECT * FROM questoes WHERE id="+id;
        Cursor cursor = database.rawQuery(sql,null);

        if(cursor.moveToNext()){
            int provaID = cursor.getInt(1);
            String enunciado = cursor.getString(2);
            String AltA = cursor.getString(3);
            String AltB = cursor.getString(4);
            String AltC = cursor.getString(5);
            String AltD = cursor.getString(6);
            String AltE = cursor.getString(7);
            String AltF = cursor.getString(8);
            char AltCorreta = cursor.getString(9).charAt(0);
            return new Questao(id,provaID,enunciado,AltA,AltB,AltC,AltD,AltE,AltF,AltCorreta);
        }
            return null;
    }
    public boolean delete(int id){
        String sql = "DELETE FROM questoes WHERE id="+id;
        try{
            database.execSQL(sql);
            Toast.makeText(context,"Questao deletada!",Toast.LENGTH_LONG).show();
            return true;
        }catch (SQLException e ){
            Toast.makeText(context,"Erro! "+e.getMessage(),Toast.LENGTH_LONG).show();
            return false;
        }
    }
    public ArrayList<Integer> getProvasID(String Cargo){
        ArrayList<Integer>ids= new ArrayList<Integer>();
        String sql = "SELECT id FROM provas where cargo='"+Cargo+"'";
        Cursor cursor = database.rawQuery(sql,null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            ids.add(id);
        }
        return ids;
    }

}
