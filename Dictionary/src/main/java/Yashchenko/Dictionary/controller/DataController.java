package Yashchenko.Dictionary.controller;

import Yashchenko.Dictionary.model.DataItem;
import Yashchenko.Dictionary.service.DataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DataItem getDataById(@PathVariable UUID id) {
        return dataService.getDataById(id);
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
    public String updateData(@PathVariable UUID id, @RequestBody DataItem dataDetails) {
        if (dataService.updateData(id, dataDetails))
            return "Data was updated successfully!";
        else
            return "Data wasn't found! Please, check the spelling";
    }

    @Operation(
            summary = "Удаление строки из таблицы"
    )
    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable UUID id) {
        if (dataService.deleteData(id))
            return "Data deleted successfully!";
        else
            return "Data wasn't found! Please, check the spelling";
    }
}