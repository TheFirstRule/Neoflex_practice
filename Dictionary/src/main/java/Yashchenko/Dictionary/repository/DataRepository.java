package Yashchenko.Dictionary.repository;

import Yashchenko.Dictionary.model.DataItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataRepository extends JpaRepository<DataItem, UUID> {
}
