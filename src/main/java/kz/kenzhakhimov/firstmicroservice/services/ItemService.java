package kz.kenzhakhimov.firstmicroservice.services;

import kz.kenzhakhimov.firstmicroservice.entities.Item;
import kz.kenzhakhimov.firstmicroservice.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void addItem(Item item){
        itemRepository.save(item);
    }
    public List<Item> getAllItems(){
        List<Item> items = itemRepository.findAll();
        if(items.size() == 0){
            return null;
        }
        else{
            return items;
        }
    }
    public void updateItem(Item updItem){
        itemRepository.save(updItem);
    }
    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }
}
