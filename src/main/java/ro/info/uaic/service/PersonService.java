package ro.info.uaic.service;

import org.springframework.stereotype.Service;
import ro.info.uaic.Database.Database;
import ro.info.uaic.entity.PersonEnt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    public List<PersonEnt> getAllPersons(){
        List<PersonEnt> persons = new ArrayList<>();

        try {
            Statement statement = (Statement) Database.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PERSON");
            PersonEnt personEnt;
            while(rs.next()) {
                personEnt = new PersonEnt(rs.getString(1), rs.getString(2));
                persons.add(personEnt);
            }
            statement.close();
            rs.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public void ADD(PersonEnt personEnt)
    {
        try {
            PreparedStatement preparedStatement = Database.getConnection()
                    .prepareStatement("INSERT INTO PERSON VALUES(?, ?)");
            preparedStatement.setString(1, personEnt.getId());
            preparedStatement.setString(2, personEnt.getNume());
            if(preparedStatement.executeUpdate() != 0) System.out.println("ADAUGAT");
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
            if(preparedStatement.executeUpdate() != 0) System.out.println("Sters");
            preparedStatement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(PersonEnt personEnt)
    {
        try {
            PreparedStatement preparedStatement = Database.getConnection()
                    .prepareStatement("UPDATE PERSON SET nume = ? WHERE id = ?");
            preparedStatement.setString(1, personEnt.getNume());
            preparedStatement.setString(2, personEnt.getId());
            if(preparedStatement.executeUpdate() != 0) System.out.println("Updatat");
            preparedStatement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
