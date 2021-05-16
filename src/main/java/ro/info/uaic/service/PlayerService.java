package ro.info.uaic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.info.uaic.Database.Database;
import ro.info.uaic.entity.PlayerEnt;
import ro.info.uaic.repo.PlayerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<PlayerEnt> getAllPlayers(){
        List<PlayerEnt> players = new ArrayList<>();

        try {
            Statement statement = (Statement) Database.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PLAYER");
            PlayerEnt player;
            while(rs.next()) {
                player = new PlayerEnt(rs.getString(1), rs.getString(2));
                players.add(player);
            }
            statement.close();
            rs.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return players;
    }

    public void ADD(PlayerEnt playerEnt)
    {
        try {
            PreparedStatement preparedStatement = Database.getConnection()
                    .prepareStatement("INSERT INTO PLAYERS VALUES(?, ?)");
            preparedStatement.setString(1, "10");
            preparedStatement.setString(2, playerEnt.getNume());
            preparedStatement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePlayer(String id) {
        try {
            PreparedStatement preparedStatement = Database.getConnection()
                    .prepareStatement("DELETE FROM PLAYER WHERE id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(PlayerEnt playerEnt, String playerId)
    {
        try {
            PreparedStatement preparedStatement = Database.getConnection()
                    .prepareStatement("UPDATE PLAYER SET name = ? WHERE id = ?");
            preparedStatement.setString(1, playerEnt.getNume());
            preparedStatement.setString(2, playerId);
            preparedStatement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
