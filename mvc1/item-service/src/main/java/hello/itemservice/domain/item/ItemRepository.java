package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }


    //여기서 updateParam은 id를 사용하지도 않기도 해서 클래스를 하나 더 만드는게 좋다.
    //중복과 명확성 중에서는 명확성을 따르는게 맞다.
    public void update(Long itemId, Item updatePaarm) {
        Item findItem = findById(itemId);
        findItem.setItemName(updatePaarm.getItemName());
        findItem.setPrice(updatePaarm.getPrice());
        findItem.setQuantity(updatePaarm.getQuantity());
    }

    public void clearStroe(){
        store.clear();
    }
}
