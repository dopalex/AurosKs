package kpac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import kpac.model.KnowledgePackage;
import kpac.util.ConnectionUtil;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgePackageDaoImpl implements KnowledgePackageDao {

    @Override
    public List<KnowledgePackage> getAll() {
        String query = "SELECT * FROM knowledge_packages";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<KnowledgePackage> packagesList = new ArrayList<>();
            while (resultSet.next()) {
                packagesList.add(parsePakageFromResultSet(resultSet));
            }
            return packagesList;
        } catch (SQLException e) {
            throw new RuntimeException("Can't find colum ");
        }
    }

    @Override
    public KnowledgePackage create(KnowledgePackage packages) {
        String insertQuery = "INSERT INTO knowledge_packages (title, description, creation_date)"
                + "VALUES (?,?,?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createCarStatement =
                        connection.prepareStatement(
                             insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            createCarStatement.setString(1, packages.getTitle());
            createCarStatement.setString(2, packages.getDescription());
            createCarStatement.setObject(3, packages.getCreationDate());
            createCarStatement.executeUpdate();
            ResultSet resultSet = createCarStatement.getGeneratedKeys();
            if (resultSet.next()) {
                packages.setId(resultSet.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't create car " + packages, e);
        }
        return packages;
    }

    @Override
    public void delete(Long id) {
        String selectQuery = "DELETE FROM knowledge_packages WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteCarStatement =
                        connection.prepareStatement(selectQuery)) {
            deleteCarStatement.setLong(1, id);
        } catch (SQLException e) {
            throw new RuntimeException("Can't delete by id " + id, e);
        }
    }

    private KnowledgePackage parsePakageFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        LocalDate time = resultSet.getObject("creation_date", LocalDate.class);
        KnowledgePackage knowledgePackage = new KnowledgePackage();
        knowledgePackage.setId(id);
        knowledgePackage.setTitle(title);
        knowledgePackage.setDescription(description);
        knowledgePackage.setCreationDate(time);
        return knowledgePackage;
    }
}
