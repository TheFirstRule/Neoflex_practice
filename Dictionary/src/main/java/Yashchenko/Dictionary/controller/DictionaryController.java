package Yashchenko.Dictionary.controller;

import Yashchenko.Dictionary.model.DictionaryItem;
import Yashchenko.Dictionary.service.DictionaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/dictionary")
@Tag(name="Dictionary Controller", description="Контроллер, управляющий таблицей Dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService service;

    @Operation(
            summary = "Вывод всех строк таблицы"
    )
    @GetMapping
    public List<DictionaryItem> findAllItems() {
        return service.findAllItems();
    }

    @Operation(
            summary = "Добавление строки в таблицу"
    )
    @PostMapping("save_item")
    public String saveItem(@RequestBody DictionaryItem item){
        service.saveItem(item);
        return "Item was added successfully!";
    }

    @Operation(
            summary = "Вывод определенной строки по ID"
    )
    @GetMapping("/{id}")
    public DictionaryItem findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @Operation(
            summary = "Обновление строки в таблице"
    )
    @PutMapping("update_item")
    public DictionaryItem updateItem(@RequestBody DictionaryItem item) {
        return service.updateItem(item);
    }

    @Operation(
            summary = "Удаление строки из таблицы"
    )
    @DeleteMapping("delete_item/{id}")
    public void deleteItem(@PathVariable UUID id) {
        service.deleteItem(id);
    }
}
