package main.sql;


public class InsertionThread implements Runnable{
    int id;
    double value;
    private static ToSQL sql;

    InsertionThread(int id, double value)
    {
        this.id = id;
        this.value = value;
    }
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
