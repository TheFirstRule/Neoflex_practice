package Yashchenko.Dictionary.impl;

import Yashchenko.Dictionary.model.DataItem;
import Yashchenko.Dictionary.repository.DataRepository;
import Yashchenko.Dictionary.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataRepository dataRepository;

    @Override
    public List<DataItem> getAllData() {
        return dataRepository.findAll();
    }

    @Override
    public DataItem getDataById(UUID id) {
        return dataRepository.findById(id).orElse(null);
    }

    @Override
    public DataItem createData(DataItem data) {
        return dataRepository.save(data);
    }

    @Override
    public DataItem updateData(UUID id, DataItem dataDetails) {
        DataItem data = dataRepository.findById(id).orElse(null);

        if (data != null) {
            data.setDictionary(dataDetails.getDictionary());
            data.setCode(dataDetails.getCode());
            data.setValue(dataDetails.getValue());
            return dataRepository.save(data);
        }
        return null;
    }

    @Override
    public void deleteData(UUID id) {
        dataRepository.deleteById(id);
    }
}
