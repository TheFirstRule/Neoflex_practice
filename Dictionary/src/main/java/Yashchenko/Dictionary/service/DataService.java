package Yashchenko.Dictionary.service;

import Yashchenko.Dictionary.model.DataItem;

import java.util.List;
import java.util.UUID;

public interface DataService {
    List<DataItem> getAllData();
    DataItem getDataById(UUID id);
    DataItem createData(DataItem data);
    Boolean updateData(UUID id, DataItem dataDetails);
    Boolean deleteData(UUID id);
}
