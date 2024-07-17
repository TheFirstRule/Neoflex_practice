package Yashchenko.Dictionary.impl;

import Yashchenko.Dictionary.model.DictionaryItem;
import Yashchenko.Dictionary.repository.ItemRepository;
import Yashchenko.Dictionary.service.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Primary
public class DictionaryServiceImpl implements DictionaryService {

    private final ItemRepository repository;

    @Override
    public List<DictionaryItem> findAllItems() {
        return repository.findAll();
    }

    @Override
    public DictionaryItem saveItem(DictionaryItem item) {
        return repository.save(item);
    }

    @Override
    public DictionaryItem findById(UUID id) {
        return repository.findItemById(id);
    }

    @Override
    public DictionaryItem updateItem(DictionaryItem item) {
        return repository.save(item);
    }

    @Override
    public void deleteItem(UUID id) {
        repository.deleteById(id);
    }
}
