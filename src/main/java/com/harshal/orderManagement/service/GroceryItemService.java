package com.harshal.orderManagement.service;

import com.harshal.orderManagement.dto.groceryItems.GroceryItemResponseDto;
import com.harshal.orderManagement.entity.GroceryItem;
import com.harshal.orderManagement.exception.GroceryItemNotFoundException;
import com.harshal.orderManagement.repository.GroceryItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroceryItemService {
    private final GroceryItemsRepository groceryItemsRepository;

    public GroceryItem createGroceryItemById(GroceryItem groceryItem) {
        return groceryItemsRepository.save(groceryItem);
    }

    public GroceryItem getGroceryItemById(Long id) {
        return groceryItemsRepository.findById(id).orElseThrow(() -> new GroceryItemNotFoundException(id));
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemsRepository.findAll();
    }

    public GroceryItem updateGroceryItem(GroceryItem groceryItem, Long id) {

        GroceryItem oldGroceryItem = groceryItemsRepository.findById(id).orElseThrow(() -> new GroceryItemNotFoundException(id));
        oldGroceryItem.setName(groceryItem.getName());
        oldGroceryItem.setPrice(groceryItem.getPrice());
        oldGroceryItem.setQuantity(groceryItem.getQuantity());
        oldGroceryItem.setCategory(groceryItem.getCategory());
        return groceryItemsRepository.save(oldGroceryItem);
    }

    public void deleteGroceryItem(Long id) {
        groceryItemsRepository.deleteById(id);
    }
}
