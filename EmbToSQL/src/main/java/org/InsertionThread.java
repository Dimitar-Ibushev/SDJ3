package org;

public class InsertionThread implements Runnable{
    int id;
    int value;
    private static ToSQL sql;

    InsertionThread(int id, int value)
    {
        this.id = id;
        this.value = value;
    }
    @Override
    public void run() {
        try
        {
            sql = new ToSQL();
            sql.insertIntoDatabase(id, value);
            sql.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
