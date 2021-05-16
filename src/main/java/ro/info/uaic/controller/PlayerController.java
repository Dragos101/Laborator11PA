package ro.info.uaic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.info.uaic.entity.PlayerEnt;
import ro.info.uaic.service.PlayerService;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping("/players")
    private List<PlayerEnt> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @DeleteMapping("players/{playerID}")
    private void deletePlayer(@PathVariable("playerID") String playerID){
        playerService.deletePlayer(playerID);
    }

    @PostMapping("players")
    private String addPlayer(@RequestBody PlayerEnt player){
        playerService.ADD(player);
        return player.getId();
    }

    @PutMapping("/players/{playerID}")
    private void update(@RequestBody PlayerEnt player, @PathVariable("playerID") String playerID){
        playerService.update(player, playerID);
    }

}
