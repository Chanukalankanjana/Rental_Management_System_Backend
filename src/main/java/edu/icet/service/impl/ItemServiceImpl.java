package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Customer;
import edu.icet.dto.Item;
import edu.icet.entity.CustomerEntity;
import edu.icet.entity.ItemEntity;
import edu.icet.repository.ItemRepository;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;
    private final ObjectMapper mapper;
    @Override
    public void addItem(Item item) {
        ItemEntity itemEntity = mapper.convertValue(item, ItemEntity.class);
        repository.save(itemEntity);
    }

    @Override
    public List<Item> getAllItem() {
        List<Item> itemList = new ArrayList();
        Iterable<ItemEntity> all = repository.findAll();

        all.forEach(itemEntity -> {
            Item item = mapper.convertValue(itemEntity, Item.class);
            itemList.add(item);
        });
        return itemList;
    }

    @Override
    public void updateItem(Item item) {
        if (repository.existsById(item.getId())){
            ItemEntity itemEntity = mapper.convertValue(item, ItemEntity.class);
            repository.save(itemEntity);
        }
    }
}
