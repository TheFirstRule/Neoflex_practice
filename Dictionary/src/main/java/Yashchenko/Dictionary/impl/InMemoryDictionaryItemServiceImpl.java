package Yashchenko.Dictionary.impl;

import Yashchenko.Dictionary.model.DictionaryItem;
import Yashchenko.Dictionary.repository.InMemoryItemDAO;
import Yashchenko.Dictionary.service.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor

public class InMemoryDictionaryItemServiceImpl implements DictionaryService {

    private final InMemoryItemDAO repository;

    @Override
    public List<DictionaryItem> findAllItems(){
        return repository.findAllItems();
    }

    @Override
    public DictionaryItem saveItem(DictionaryItem item) {
        return repository.saveItem(item);
    }

    @Override
    public DictionaryItem findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public DictionaryItem updateItem(DictionaryItem item) {
        return repository.updateItem(item);
    }

    @Override
    public void deleteItem(UUID id) {
        repository.deleteItem(id);
    }
}
