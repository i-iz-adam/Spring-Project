package com.decimate.site.controller;

import com.decimate.site.entity.Player;
import com.decimate.site.entity.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/")
    public ModelAndView displayHomePage(Map<String, Object> model) {

        model.put("title", "Decimate RSPS");

        Player player = new Player();
        player.setEmail("naxosrsps@gmail.com");
        player.setPassword("AsecretPassword");
        player.setUsername("Netty");

        playerRepository.save(player);
        model.put("user", player);
        return new ModelAndView("index/index", model);
    }

    @GetMapping("/all_users")
    public @ResponseBody
    Iterable<Player> getAllUsers() {
        // This returns a JSON or XML with the users
        return playerRepository.findAll();
    }
}
