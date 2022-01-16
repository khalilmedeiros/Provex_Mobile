package br.edu.ufam.icomp.provex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Provex.db";
    private static final String SQL_CREATE_PROVA = "CREATE TABLE provas ("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT, nome_Empresa VARCHAR, nome_OrgPub VARCHAR,"+
            " nome_Estado VARCHAR, ano INTEGER, nivel VARCHAR, cargo VARCHAR)";

    private static final String SQL_CREATE_QUESTAO = "CREATE TABLE questoes("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,provaID INTEGER NOT NULL, enunciado VARCHAR, altA VARCHAR, altB VARCHAR,"+
            "altC VARCHAR, altD VARCHAR, altE VARCHAR, altF VARCHAR, altCorreta VARCHAR,FOREIGN KEY(provaID) REFERENCES provas(id))";

    private static final String SQL_POPULATE_PROVA1 = "INSERT INTO provas VALUES"+
            "(NULL, 'FCC', 'UFAM', 'AM', '2016', 'Superior','Professor')";
    private static final String SQL_POPULATE_PROVA2 = "INSERT INTO provas VALUES"+
            "(NULL, 'CESPE', 'UFAM', 'AM', '2018', 'Superior','Professor')";

    private static final String SQL_POPULATE_QUESTAO ="INSERT INTO questoes VALUES"+
            "(NULL,1,"+
            "'Nos Termos da Lei de Diretrizes e Bases da Educação Nacional, Lei 9.394/96, é INCORRETO afirmar:',"+
            "' A escola poderá reclassificar os alunos, inclusive quando se tratar de transferências entre" +
            "estabelecimentos situados no país e no exterior, tendo como base as normas curriculares gerais.',"+
            "'Nos níveis fundamental e médio, a carga horária mínima anual será de oitocentas horas, distribuídas por" +
            "um mínimo de duzentos dias de efetivo trabalho escolar, excluído o tempo reservado aos exames finais," +
            "quando houver',"+
            "'Ao tratar da verificação do rendimento escolar, o regimento deverá prever possibilidade de aceleração" +
            "de estudos para alunos com atraso escolar',"+
            "'Poderão organizar-se classes, ou turmas, com alunos de séries distintas, com níveis equivalentes de" +
            "adiantamento na matéria, somente para o ensino de línguas estrangeiras ou artes.',"+
            "'',"+
            "'',"+
            "'C')";
    private static final String SQL_POPULATE_QUESTAO2 ="INSERT INTO questoes VALUES"+
            "(NULL,1,"+
            "'Observados os termos da Lei 8.069/90, Estatuto da Criança e do Adolescente, é INCORRETO afirmar:',"+
            "'Os municípios, com apoio dos estados e da União, estimularão e facilitarão a destinação de recursos e" +
            "espaços para programações culturais, esportivas e de lazer voltadas para a infância e a juventude',"+
            "'No processo educacional, respeitar-se-ão os valores culturais, artísticos e históricos próprios do contexto" +
            "social da criança e do adolescente, garantindo-se que esses valores não sejam motivo de qualquer" +
            "discussão em sala de aula.',"+
            "'Considera-se criança, para os efeitos dessa Lei, a pessoa até doze anos de idade incompletos, e" +
            "adolescente, aquela entre doze e dezoito anos de idade',"+
            "'É direito dos pais ou responsáveis ter ciência do processo pedagógico, bem como participar da definição" +
            "das propostas educacionais',"+
            "'',"+
            "'',"+
            "'D')";
    private static final String SQL_POPULATE_QUESTAO3 ="INSERT INTO questoes VALUES"+
            "(NULL,1,"+
            "'As ideias abaixo apresentam concepções de Paulo Freire, expressas em seu livro Pedagogia da autonomia," +
            "em relação ao processo ensino-aprendizagem, EXCETO',"+
            "'Divinizar ou diabolizar a tecnologia ou a ciência é uma forma positiva e menos perigosa de pensar o" +
            "processo ensino-aprendizagem',"+
            "'Nas condições de verdadeira aprendizagem, os educandos vão se transformando em reais sujeitos da" +
            "construção e da reconstrução do saber ensinado, ao lado do educador, igualmente sujeito do processo',"+
            "'As condições para se aprender criticamente implicam ou exigem a presença de educadores e de" +
            "educandos criadores, instigadores, inquietos, rigorosamente curiosos, humildes e persistentes. ',"+
            "'Ensinar exige compreender que a educação é uma forma de intervenção no mundo.',"+
            "'',"+
            "'',"+
            "'D')";
    private static final String SQL_POPULATE_QUESTAO4 ="INSERT INTO questoes VALUES"+
            "(NULL,1,"+
            "'Observadas as orientações didáticas, “sequências didáticas” podem ser conceituadas como: ',"+
            "'Critérios para analisar nossa prática e, se for conveniente, para reorientá-la.',"+
            "'Conjunto de métodos a serem utilizados conforme a necessidade imposta pelos conteúdos.',"+
            "'Conjunto de atividades ordenadas, estruturadas e articuladas para a realização de certos objetivos" +
            "educacionais, que têm um princípio e um fim conhecidos tanto pelos professores como pelos alunos',"+
            "'Método direcionador das ações pedagógicas',"+
            "'',"+
            "'',"+
            "'A')";
    private static final String SQL_POPULATE_QUESTAO5 ="INSERT INTO questoes VALUES"+
            "(NULL,1,"+
            "'“Se o objetivo é que o aluno aprenda a produzir e a interpretar textos, não é possível tomar como unidade " +
            "básica de ensino nem a letra, nem a sílaba, nem a palavra, nem a frase que, descontextualizadas, pouco têm " +
            "a ver com a competência discursiva, que é questão central. Dentro desse marco, a unidade básica de ensino " +
            "só pode ser o texto, mas isso não significa que não se enfoquem palavras ou frases nas situações didáticas " +
            "específicas que o exijam.” Considerada essa afirmativa, é INCORRETO afirmar: ',"+
            "'Não se formam bons leitores oferecendo materiais de leitura empobrecidos, justamente no momento em " +
            "que as crianças são iniciadas no mundo da escrita',"+
            "'Para desenvolvimento da competência discursiva, o ensino da produção de textos deve iniciar-se " +
            "durante o processo de alfabetização, não importando o método adotado.',"+
            "'A ênfase que se está dando ao conhecimento sobre as características discursivas da linguagem não" +
            "significa que a aquisição da escrita alfabética deixa de ser importante',"+
            "'O autor está denunciando os erros contidos nos livros didáticos que adotam como método de" +
            "alfabetização o processo fônico',"+
            "'',"+
            "'',"+
            "'B')";
    private static final String SQL_POPULATE_QUESTAO6 ="INSERT INTO questoes VALUES"+
            "(NULL,2,"+
            "'O texto Saberes e Práticas de Inclusão, publicado pelo Ministério da Educação, orienta que: “Necessidades " +
            "educacionais podem ser identificadas em diversas situações representativas de dificuldades de " +
            "aprendizagem, como decorrência de condições individuais, econômicas ou socioculturais dos alunos.” " +
            "O texto acima citado elenca os grupos que devem ser beneficiados com as políticas públicas de inclusão" +
            "escolar, entre os quais NÃO se encontra: ',"+
            "'Crianças com condições físicas, intelectuais, sociais, emocionais e sensoriais diferenciadas. ',"+
            "'Crianças de populações rurais, ainda que não apresentem qualquer dificuldade pedagógica ou social. ',"+
            "'Crianças com deficiência ou bem dotadas. ',"+
            "'Crianças trabalhadoras ou que vivem nas ruas ou de minorias linguísticas, étnicas ou culturais.',"+
            "'',"+
            "'',"+
            "'B')";
    private static final String SQL_POPULATE_QUESTAO7 ="INSERT INTO questoes VALUES"+
            "(NULL,2,"+
            "'Nos termos dos Referenciais Curriculares Nacionais para a Educação Infantil, Vol. 3, é CORRETO " +
            "afirmar:',"+
            "'Na reflexão acerca das possibilidades posturais e motoras oferecidas no conjunto das atividades, é " +
            "desnecessário planejar situações de trabalho voltadas para aspectos mais específicos do desenvolvimento " +
            "corporal e motor, considerando que as crianças pequenas estão sempre mudando de postura.',"+
            "' O professor de crianças pequenas não precisa avaliar constantemente o tempo de contenção motora ou " +
            "de manutenção de uma mesma postura. A própria criança já o faz instintivamente. ',"+
            "'As diferentes atividades que ocorrem nas instituições requerem das crianças posturas corporais distintas. " +
            "Cabe ao professor organizar o ambiente de forma a garantir a postura mais adequada para cada " +
            "atividade, não as restringindo a modelos estereotipados. ',"+
            "' Durante o processo de definição da lateralidade, o professor deve intervir, constantemente, corrigindo " +
            "quando alguma criança manifestar a preferência pelo uso da mão esquerda, definindo-se como canhota.',"+
            "'',"+
            "'',"+
            "'D')";


    private static final String SQL_DELETE_PROVA = "DROP TABLE IF EXISTS provas";
    private static final String SQL_DELETE_QUESTAO ="DROP TABLE IF EXISTS questoes";

    public Database(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PROVA);
        db.execSQL(SQL_POPULATE_PROVA1);
        db.execSQL(SQL_POPULATE_PROVA2);
        db.execSQL("PRAGMA foreign_keys = ON;");
        db.execSQL(SQL_CREATE_QUESTAO);
        db.execSQL(SQL_POPULATE_QUESTAO);
        db.execSQL(SQL_POPULATE_QUESTAO2);
        db.execSQL(SQL_POPULATE_QUESTAO3);
        db.execSQL(SQL_POPULATE_QUESTAO4);
        db.execSQL(SQL_POPULATE_QUESTAO5);
        db.execSQL(SQL_POPULATE_QUESTAO6);
        db.execSQL(SQL_POPULATE_QUESTAO7);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_PROVA);
        db.execSQL(SQL_DELETE_QUESTAO);
        onCreate(db);
    }
}
