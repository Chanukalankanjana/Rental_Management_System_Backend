package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.dto.Item;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin
@RequiredArgsConstructor
public class ItemController {
    private final ItemService service;
    @PostMapping("/add-item")
    @ResponseStatus(HttpStatus.CREATED)
    void addItem(@RequestBody Item item){
        service.addItem(item);
    }

    @GetMapping("/get-all")
    List<Item> getAllItem(){
        return service.getAllItem();
    }
}
