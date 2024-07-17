package Yashchenko.Dictionary.repository;

import Yashchenko.Dictionary.model.DictionaryItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Repository
public class InMemoryItemDAO {

    private final List<DictionaryItem> ITEMS = new ArrayList<>();

    public List<DictionaryItem> findAllItems(){
        return ITEMS;
    }

    public DictionaryItem saveItem(DictionaryItem item) {
        ITEMS.add(item);
        return item;
    }

    public DictionaryItem findById(UUID id) {
        return ITEMS.stream()
                .filter(element->element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public DictionaryItem updateItem(DictionaryItem item) {
        var itemIndex = IntStream.range(0,ITEMS.size())
                .filter(index->ITEMS.get(index).getId().equals(item.getId()))
                .findFirst()
                .orElse(-1);
        if (itemIndex > -1){
            ITEMS.set(itemIndex, item);
            return item;
        }
        return null;
    }

    public void deleteItem(UUID id) {
        var item = findById(id);
        if (item != null) {
            ITEMS.remove(item);
        }
    }
}
