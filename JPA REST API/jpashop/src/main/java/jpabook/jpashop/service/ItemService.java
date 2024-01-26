package jpabook.jpashop.service;

import jpabook.jpashop.controller.BookForm;
import jpabook.jpashop.controller.UpdateItemDto;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, UpdateItemDto itemParam){
        Book findItem = (Book) itemRepository.findOne(itemId);
        findItem.setName(itemParam.getName());
        findItem.setPrice(itemParam.getPrice());
        findItem.setStockQuantity(itemParam.getStockQuantity());
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
