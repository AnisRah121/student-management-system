package StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.Student;

public class StudentServise {

    // SAVE
    public int save(Student st) {

        int res = 0;
        String sql = "INSERT INTO student VALUES (?,?,?)";

        Connection connection = ConnectionPool.getConnection();

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, st.getId());
            pstm.setString(2, st.getName());
            pstm.setInt(3, st.getAge());

            res = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.receiveConnection(connection);
        }

        return res;
    }

    // UPDATE
    public int update(Student st) {

        int res = 0;
        String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";

        Connection connection = ConnectionPool.getConnection();

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, st.getName());
            pstm.setInt(2, st.getAge());
            pstm.setInt(3, st.getId());

            res = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.receiveConnection(connection);
        }

        return res;
    }

    // FETCH ALL
    public List<Student> fetchAll() {

        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";

        Connection connection = ConnectionPool.getConnection();

        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.receiveConnection(connection);
        }

        return list;
    }

    // DELETE
    public int delete(int id) {

        int res = 0;
        String sql = "DELETE FROM student WHERE id = ?";

        Connection connection = ConnectionPool.getConnection();

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            res = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.receiveConnection(connection);
        }

        return res;
    }

    // EXIT
    public boolean exitss() {
        return true;
    }
}
