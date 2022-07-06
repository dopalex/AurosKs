package kpac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kpac.model.KnowledgePackageSet;
import kpac.util.ConnectionUtil;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgePackageSetDaoImpl implements KnowledgePackageSetDao {
    @Override
    public List<KnowledgePackageSet> getAll() {
        String query = "SELECT * FROM knowledge_package_sets";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<KnowledgePackageSet> packageSets = new ArrayList<>();
            while (resultSet.next()) {
                packageSets.add(parseKnowledgeSet(resultSet));
            }
            return packageSets;
        } catch (SQLException e) {
            throw new RuntimeException("Can't find colum ");
        }
    }

    public KnowledgePackageSet create(KnowledgePackageSet packageSet) {
        String insertQuery = "INSERT INTO knowledge_package_sets (title)"
                + " VALUES(?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createCarStatement =
                        connection.prepareStatement(
                             insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            createCarStatement.setString(1, packageSet.getTitle());
            createCarStatement.executeUpdate();
            ResultSet resultSet = createCarStatement.getGeneratedKeys();
            if (resultSet.next()) {
                packageSet.setId(resultSet.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't create car " + packageSet, e);
        }
        return packageSet;
    }

    @Override
    public void delete(Long id) {
        String selectQuery = "DELETE FROM knowledge_package_sets WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteCarStatement =
                        connection.prepareStatement(selectQuery)) {
            deleteCarStatement.setLong(1, id);
        } catch (SQLException e) {
            throw new RuntimeException("Can't delete by " + id, e);
        }
    }

    private KnowledgePackageSet parseKnowledgeSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String tile = resultSet.getString("title");
        KnowledgePackageSet packageSet = new KnowledgePackageSet();
        packageSet.setId(id);
        packageSet.setTitle(tile);
        return packageSet;
    }
}
