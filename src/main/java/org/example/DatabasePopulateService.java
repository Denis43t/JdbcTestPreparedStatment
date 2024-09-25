package org.example;

import org.example.utility.SqlFileReaderUtility;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabasePopulateService {
    public void populateUsersTable() throws Exception {
        Path path= Path.of("sql/populate_db.sql");
        SqlFileReaderUtility sqlFileReaderUtility = new SqlFileReaderUtility();
        String sqlSript = sqlFileReaderUtility.convertSqlScriptToString(path);
        Connection connection=Database.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sqlSript)) {
            statement.execute();
        }
    }

    public static void main(String[] args) throws Exception {
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();
        databasePopulateService.populateUsersTable();
    }
}
