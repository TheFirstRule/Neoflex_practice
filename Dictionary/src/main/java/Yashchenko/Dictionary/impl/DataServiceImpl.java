package Yashchenko.Dictionary.impl;

import Yashchenko.Dictionary.model.DataItem;
import Yashchenko.Dictionary.model.DictionaryItem;
import Yashchenko.Dictionary.repository.DataRepository;
import Yashchenko.Dictionary.repository.ItemRepository;
import Yashchenko.Dictionary.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DataServiceImpl implements DataService {

    private DataRepository dataRepository;
    private ItemRepository itemRepository;

    @Override
    public List<DataItem> getAllData() {
        return dataRepository.findAll();
    }

    @Override
    public DataItem getDataById(UUID id) {
        return dataRepository.findById(id).orElse(null);
    }

    @Override
    public DataItem createData(DataItem data)
    {
        if (dataRepository.existsById(data.getDictionary().getId()))
        {
            dataRepository.save(data);
            return null;
            }
        else
        {
            DictionaryItem dictionary = new DictionaryItem();
            dictionary.setId(data.getDictionary().getId());
            dictionary.setCode(data.getDictionary().getCode());
            dictionary.setDescription(data.getDictionary().getDescription());
            itemRepository.save(dictionary);
            DataItem newData = new DataItem();
            newData.setCode(data.getCode());
            newData.setValue(data.getValue());
            newData.setDictionary(dictionary);
            dataRepository.save(newData);
            return null;
        }
    }

    @Override
    public Boolean updateData(UUID id, DataItem dataDetails) {
        if (!dataRepository.existsById(id))
            return false;

        DataItem data = dataRepository.findById(id).orElse(null);

        if (data != null) {
            data.setDictionary(dataDetails.getDictionary());
            data.setCode(dataDetails.getCode());
            data.setValue(dataDetails.getValue());
            dataRepository.save(data);
        }
        return true;
    }

    @Override
    public Boolean deleteData(UUID id) {
        if (dataRepository.existsById(id))
        {
            dataRepository.deleteById(id);
            return true;
            }
        else
            return false;
    }
}
