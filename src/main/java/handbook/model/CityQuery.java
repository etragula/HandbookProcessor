package handbook.model;

public enum CityQuery {

    CREATE_TABLE_SQL("create table city (\r\n" +
            "  id  int(3) primary key auto_increment,\r\n" +
            "  name varchar(30),\r\n" +
            "  region varchar(30),\r\n" +
            "  district varchar(30),\r\n" +
            "  population int,\r\n" +
            "  foundation int\r\n" +
            "  );"),

    INSERT_CITY_SQL("INSERT INTO city" +
            " (name, region, district, population, foundation)" +
            " VALUES (?, ?, ?, ?, ?);"),

    DROP_TABLE_SQL("DROP TABLE city"),

    SELECT_QUERY_SQL("select * from city"),

    UPDATE_USERS_SQL("update city set name = ?, region = ?, district = ?, " +
            "population = ?, foundation = ? where id = ?;"),

    DELETE_ROW_CITY("delete from city where id = ");

    private String query;

    CityQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return query;
    }
}
