package Yashchenko.Dictionary.service;

import Yashchenko.Dictionary.model.DictionaryItem;

import java.util.List;
import java.util.UUID;


public interface DictionaryService {

    List<DictionaryItem> findAllItems();
    DictionaryItem saveItem(DictionaryItem item);
    DictionaryItem findById(UUID id);
    Boolean updateItem(DictionaryItem item);
    Boolean deleteItem(UUID id);
}
