package com.inna.giflib.controller;

import com.inna.giflib.data.GifRepository;
import com.inna.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GifController {
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifts(ModelMap modelMap){
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping(value = "/", params = "q")
    public String gifSearch(@RequestParam("q") String q, ModelMap modelMap){
        List<Gif> allGifs = gifRepository.findAllByName(q);
        modelMap.put("gifs", allGifs);
        return "search";

    }
}
