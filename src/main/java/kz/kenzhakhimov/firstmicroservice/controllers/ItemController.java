package kz.kenzhakhimov.firstmicroservice.controllers;

import kz.kenzhakhimov.firstmicroservice.entities.Item;
import kz.kenzhakhimov.firstmicroservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
    @PostMapping
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }
}
