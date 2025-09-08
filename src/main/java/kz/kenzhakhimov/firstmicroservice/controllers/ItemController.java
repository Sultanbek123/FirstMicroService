package kz.kenzhakhimov.firstmicroservice.controllers;

import kz.kenzhakhimov.firstmicroservice.entities.Item;
import kz.kenzhakhimov.firstmicroservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = itemService.getAllItems();
        if(items == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(items);
        }
    }
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item){
        itemService.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success added");
    }
    @PutMapping()
    public ResponseEntity<?> updateItem(@RequestBody Item updItem){
        itemService.updateItem(updItem);
        return ResponseEntity.status(HttpStatus.OK).body("Success update");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") Long id){
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).body("Success deleted");
    }
}
