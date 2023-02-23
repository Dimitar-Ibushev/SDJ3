package org;

import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    private static ToSQL sql;
    private static Embedded emb;
    private static Gson gson;
    private String JSON;
    private static ArrayList<Reading> entries;
    private final int S1 = 1, S2 = 2, S3 = 3;

    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        sql = new ToSQL();
        emb = new Embedded();
        entries = new ArrayList<Reading>();
        gson = new Gson();
        sql.getConnection();
        //sql.insertIntoDatabase(1, 43);

        sql.close();

    }

    public class Reading
    {
        int id;
        float value;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
        }
    }
}
