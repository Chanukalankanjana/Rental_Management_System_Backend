package edu.icet.service;

import edu.icet.dto.Item;

import java.util.List;

public interface ItemService {

    void addItem(Item item);

    List<Item> getAllItem();

    void updateItem(Item item);

    boolean deleteItem(Integer id);
}
