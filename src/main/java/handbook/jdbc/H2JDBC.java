package handbook.jdbc;

public interface H2JDBC<Models> {

    abstract void creatTable();

    abstract void dropTable();

    abstract void insertRecord(Models model);

    abstract void updateRecord(int id, Models newModel);

    abstract void selectRecord();

    abstract void deleteRecord(int id);
}
