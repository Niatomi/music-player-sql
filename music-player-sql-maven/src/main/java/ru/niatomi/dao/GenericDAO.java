package ru.niatomi.dao;

import java.util.List;

/**
 * @author Niatomi
 */
public interface GenericDAO<Key, Item> {

    /**
     * Запрос всех данных.
     * @return 
     */
    List<Item> select();
    
    /**
     * Запрос данных ограниченного количества данных с сдвигом.
     * @param offset
     * @param limit
     * @return 
     */
    List<Item> select(int offset, int limit);
    
    /**
     * Получение объекта по ключу.
     * @param key
     * @return 
     */
    Item findByKey(Key key);
    
    /**
        * Удаление объекта по ключу.
     * @param key
     * @return 
     */
    void removeByKey(Key key);
    
    /**
     * Добавление объекта.
     * @param item
     * @return 
     */
    void insert(Item item);
    
    /**
     * Обновление объекта.
     * @param item
     * @return 
     */
    void update(Integer key, Item item);
}
