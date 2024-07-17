package Yashchenko.Dictionary.controller;

import Yashchenko.Dictionary.model.DictionaryItem;
import Yashchenko.Dictionary.service.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService service;

    @GetMapping
    public List<DictionaryItem> findAllItems() {
        return service.findAllItems();
    }

    @PostMapping("save_item")
    public String saveItem(@RequestBody DictionaryItem item){
        service.saveItem(item);
        return "Item was added successfully!";
    }

    @GetMapping("/{id}")
    public DictionaryItem findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("update_item")
    public DictionaryItem updateItem(@RequestBody DictionaryItem item) {
        return service.updateItem(item);
    }

    @DeleteMapping("delete_item/{id}")
    public void deleteItem(@PathVariable UUID id) {
        service.deleteItem(id);
    }
}
