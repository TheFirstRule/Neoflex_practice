package Yashchenko.Dictionary.controller;

import Yashchenko.Dictionary.exceptions.ItemNotFoundException;
import Yashchenko.Dictionary.model.DictionaryItem;
import Yashchenko.Dictionary.service.DictionaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping
    public String saveItem(@RequestBody DictionaryItem item){
        service.saveItem(item);
        return "Item was added successfully!";
    }

    @Operation(
            summary = "Вывод определенной строки по ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<DictionaryItem> getItem(@PathVariable UUID id) {
        try {
            DictionaryItem item = service.findById(id);
            return ResponseEntity.ok(item);
        } catch (ItemNotFoundException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @Operation(
            summary = "Обновление строки в таблице"
    )
    @PutMapping
    public ResponseEntity<Void> updateItem(@RequestBody DictionaryItem item) {
        try {
            service.updateItem(item);
            return ResponseEntity.noContent().build();
        } catch (ItemNotFoundException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @Operation(
            summary = "Удаление строки из таблицы"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable UUID id) {
        try
        {
            service.deleteItem(id);
            return ResponseEntity.ok(service.findById(id));
        }
        catch (ItemNotFoundException ex)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ex.getMessage());
        }
    }
}
