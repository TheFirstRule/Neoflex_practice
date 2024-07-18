package Yashchenko.Dictionary.impl;

import Yashchenko.Dictionary.exceptions.ItemNotFoundException;
import Yashchenko.Dictionary.model.DictionaryItem;
import Yashchenko.Dictionary.repository.ItemRepository;
import Yashchenko.Dictionary.service.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with id: " + id));
    }

    @Override
    public void updateItem(DictionaryItem item) {
        Optional<DictionaryItem> optionalItem = repository.findById(item.getId());
        if (optionalItem.isEmpty()) {
            throw new ItemNotFoundException("Item not found with id: " + item.getId());
        }
        repository.save(item);
    }

    @Override
    public void deleteItem(UUID id) {
        DictionaryItem item = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with id: " + id));
        repository.deleteById(id);
    }
}
