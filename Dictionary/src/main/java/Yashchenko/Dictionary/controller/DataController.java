package Yashchenko.Dictionary.controller;

import Yashchenko.Dictionary.exceptions.ItemNotFoundException;
import Yashchenko.Dictionary.model.DataItem;
import Yashchenko.Dictionary.model.DictionaryItem;
import Yashchenko.Dictionary.service.DataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/data")
@Tag(name="Data Controller", description="Контроллер, управляющий таблицей Data")
public class DataController {

    @Autowired
    private DataService dataService;

    @Operation(
            summary = "Вывод всех строк таблицы"
    )
    @GetMapping
    public List<DataItem> getAllData() {
        return dataService.getAllData();
    }

    @Operation(
            summary = "Вывод определенной строки по ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<DataItem> getDataById(@PathVariable UUID id) {
        try {
            DataItem item = dataService.getDataById(id);
            return ResponseEntity.ok(item);
        } catch (ItemNotFoundException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @Operation(
            summary = "Добавление строки в таблицу"
    )
    @PostMapping
    public DataItem createData(@RequestBody DataItem data) {
        return dataService.createData(data);
    }

    @Operation(
            summary = "Обновление строки в таблице"
    )
    @PutMapping("/{id}")
    public ResponseEntity<DataItem> updateData(@PathVariable UUID id, @RequestBody DataItem data) {
        try {
            DataItem existingData = dataService.getDataById(id);
            existingData.setDictionary(data.getDictionary());
            existingData.setCode(data.getCode());
            existingData.setValue(data.getValue());
            dataService.updateData(existingData.getId(), existingData);
            return ResponseEntity.ok(existingData);
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
            dataService.deleteData(id);
            return ResponseEntity.ok().build();
        }
        catch (ItemNotFoundException ex)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ex.getMessage());
        }
    }
}