package Yashchenko.Dictionary.repository;

import Yashchenko.Dictionary.model.DictionaryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<DictionaryItem, UUID> {

    void deleteById(UUID id);
    DictionaryItem findItemById(UUID id);

}
