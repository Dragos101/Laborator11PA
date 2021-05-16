package ro.info.uaic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.info.uaic.Database.Database;
import ro.info.uaic.entity.PersonEnt;
import ro.info.uaic.repo.PersonRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<PersonEnt> getAllPersons(){
        List<PersonEnt> players = new ArrayList<>();

        try {
            Statement statement = (Statement) Database.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PERSON");
            PersonEnt player;
            while(rs.next()) {
                player = new PersonEnt(rs.getString(1), rs.getString(2));
                players.add(player);
            }
            statement.close();
            rs.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return players;
    }

    public void ADD(PersonEnt personEnt)
    {
        try {
            PreparedStatement preparedStatement = Database.getConnection()
                    .prepareStatement("INSERT INTO PERSON VALUES(?, ?)");
            preparedStatement.setString(1, "10");
            preparedStatement.setString(2, personEnt.getNume());
            preparedStatement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(String id) {
        try {
            PreparedStatement preparedStatement = Database.getConnection()
                    .prepareStatement("DELETE FROM PERSON WHERE id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(PersonEnt personEnt, String playerId)
    {
        try {
            PreparedStatement preparedStatement = Database.getConnection()
                    .prepareStatement("UPDATE PERSON SET name = ? WHERE id = ?");
            preparedStatement.setString(1, personEnt.getNume());
            preparedStatement.setString(2, playerId);
            preparedStatement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
