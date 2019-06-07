package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Player;
import com.example.demo.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {
	@Autowired
	private PlayerService playerService;

    //ラジオボタン用変数
    private Map<String, String> radioMarriage;

    /**
     * ラジオボタンの初期化メソッド.
     */
    private Map<String, String> initRadioMarrige() {

        Map<String, String> radio = new LinkedHashMap<>();

        // 既婚、未婚をMapに格納
        radio.put("既婚", "true");
        radio.put("未婚", "false");

        return radio;
    }

	@GetMapping
	public String index(Model model) {
		model.addAttribute("players", playerService.findAll());
		return "players/index";
	}

	@GetMapping("new")
	public String newPlayer(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
		return "players/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("player", playerService.findOne(id));
		return "players/edit";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("player", playerService.findOne(id));
		return "players/show";
	}

	@PostMapping
	public String create(@Valid @ModelAttribute Player player, BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) return "players/new";
		playerService.save(player);
		return "redirect:/players";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @Valid @ModelAttribute Player player, BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) return "players/edit";
		player.setId(id);
		playerService.update(player);
		return "redirect:/players";
	}

	@DeleteMapping("{id}")
	public String destory(@PathVariable Long id) {
		playerService.delete(id);
		return "redirect:/players";
	}
}
