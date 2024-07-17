package Yashchenko.Dictionary.service;

import Yashchenko.Dictionary.model.DictionaryItem;

import java.util.List;
import java.util.UUID;


public interface DictionaryService {

    List<DictionaryItem> findAllItems();
    DictionaryItem saveItem(DictionaryItem item);
    DictionaryItem findById(UUID id);
    DictionaryItem updateItem(DictionaryItem item);
    void deleteItem(UUID id);
}
