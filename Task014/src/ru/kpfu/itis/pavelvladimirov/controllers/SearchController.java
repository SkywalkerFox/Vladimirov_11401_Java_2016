package ru.kpfu.itis.pavelvladimirov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Павел on 23.03.2016.
 */
@Controller
@RequestMapping("/search/{searcher:\\w+}")
public class SearchController {
    @RequestMapping(method = RequestMethod.GET)
    public String searchPage(ModelMap modelMap, @PathVariable String searcher) {
        String name = "";
        if (searcher.contains("baidu")) {
            searcher = "www." + searcher + ".com/s" ;
            name = "wd";
        }
        if (searcher.contains("bing")) {
            searcher = "www." + searcher + ".com/search";
            name = "q";
        }
        if (searcher.contains("yahoo")) {
            searcher = "search." + searcher + ".com/search";
            name = "p";
        }
        if (searcher.contains("aol")) {
            searcher = "search." + searcher + ".com/search";
            name = "q";
        }
        modelMap.put("searcher", searcher);
        modelMap.put("name", name);
        return "search";
    }
}
