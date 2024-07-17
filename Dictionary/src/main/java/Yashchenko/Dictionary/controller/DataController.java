package Yashchenko.Dictionary.controller;

import Yashchenko.Dictionary.model.DataItem;
import Yashchenko.Dictionary.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping
    public List<DataItem> getAllData() {
        return dataService.getAllData();
    }

    @GetMapping("/{id}")
    public DataItem getDataById(@PathVariable UUID id) {
        return dataService.getDataById(id);
    }

    @PostMapping
    public DataItem createData(@RequestBody DataItem data) {
        return dataService.createData(data);
    }

    @PutMapping("/{id}")
    public DataItem updateData(@PathVariable UUID id, @RequestBody DataItem dataDetails) {
        return dataService.updateData(id, dataDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable UUID id) {
        dataService.deleteData(id);
    }
}