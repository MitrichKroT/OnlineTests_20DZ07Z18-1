package com.acquisio.basic.sql.question01;

import com.acquisio.util.dbutil.H2DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Write a query to extract the number of employees that are working on each project.
 * -- The select should output those columns
 * -- |ProjectTitle|NumberOfEmployees|
 *
 * Here is the database schema to use.
 * <p>
 * employees                             projects
 * +---------------+---------+           +---------------+---------+
 * | id            | int     |<----+  +->| id            | int     |
 * | first_name    | varchar |     |  |  | title         | varchar |
 * | last_name     | varchar |     |  |  | start_date    | date    |
 * | salary        | int     |     |  |  | end_date      | date    |
 * | department_id | int     |--+  |  |  | budget        | int     |
 * +---------------+---------+  |  |  |  +---------------+---------+
 * |  |  |
 * departments                  |  |  |  employees_projects
 * +---------------+---------+  |  |  |  +---------------+---------+
 * | id            | int     |<-+  |  +--| project_id    | int     |
 * | name          | varchar |     +-----| employee_id   | int     |
 * +---------------+---------+           +---------------+---------+
 */
public class Aggregation {
    public static void main(String[] args) throws SQLException {
        H2DBUtil.startDatabase();
        try {
            Aggregation instance = new Aggregation();
            instance.printNumberOfEmployeesPerProject();
        } finally {
            H2DBUtil.stopDatabase();
        }
    }

    private void printNumberOfEmployeesPerProject() throws SQLException {
        try (Connection conn = H2DBUtil.getConnection()) {
            // Start : For consultation only, can be removed
//            H2DBUtil.displayTableRows(conn, "projects");
//            H2DBUtil.displayTableRows(conn, "departments");
//            H2DBUtil.displayTableRows(conn, "employees");
//            H2DBUtil.displayTableRows(conn, "employees_projects");
            // End : For consultation only, can be removed

            // See requirement in this class javadoc
            String query = "\n" +
                    "SELECT\n" +
                    "PRJ.title as ProjectTitle,\n" +
                    "COUNT(EMP.employee_id) as NumberOfEmployees\n" +
                    "FROM projects AS PRJ, employees_projects as EMP \n" +
                    "WHERE  PRJ.id=EMP.project_id\n" +
                    "GROUP BY PRJ.title\n";

            ResultSet resultSet = conn.createStatement().executeQuery(query);
            H2DBUtil.displayResultSet(resultSet);
        }
    }
}
