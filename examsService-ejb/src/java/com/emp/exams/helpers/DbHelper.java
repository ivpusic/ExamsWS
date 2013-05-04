package com.emp.exams.helpers;

import com.emp.exams.examsService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class DbHelper {
    /*
     * Connect to database
     */
    private Connection connectToDatabase() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(examsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/emp_database;create=true;user=emp_user;password=emp_pass");
        } catch (SQLException ex) {
            Logger.getLogger(examsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    /*
     * Execute commands from command string, and by parameters array
     */
    private ResultSet executeCommand(String command, String... parameters) {
        Connection conn;
        PreparedStatement prepStmt;

        ResultSet rs = null;
        try {
            conn = this.connectToDatabase();
            prepStmt = conn.prepareStatement(command);

            for (int i = 1; i <= parameters.length; i++) {
                prepStmt.setString(i, parameters[i - 1]);
            }

            rs = prepStmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    /*
     * Find record in table by id
     */
    protected ResultSet findRecordById(int id, String table) {
        String selectStatement = "SELECT * FROM APP." + table + " WHERE id=?";
        return this.executeCommand(selectStatement, Integer.toString(id));
    }

    /*
     * Find records by fk value
     */
    protected ResultSet findRecordByForeignKey(String table, String fkName, int fkValue) {
        String selectStatement = "SELECT * FROM APP." + table + " WHERE " + fkName + "=?";
        return this.executeCommand(selectStatement, Integer.toString(fkValue));
    }

    /*
     * Find records by fk value and come additional condition
     */
    protected ResultSet findRecordByForeignKey(String table, String fkName, int fkValue, String condName, int condValue) {
        String selectStatement = "SELECT * FROM APP." + table + " WHERE " + fkName + "=? AND " + condName + "=?";
        return this.executeCommand(selectStatement, Integer.toString(fkValue), Integer.toString(condValue));
    }

    /*
     * Find all records in specified table
     */
    protected ResultSet findAllRecords(String table) {
        String selectStatement = "SELECT * FROM APP." + table;
        return this.executeCommand(selectStatement);
    }
}
