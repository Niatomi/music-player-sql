package ru.niatomi.dao;

import java.util.List;

/**
 * @author Niatomi
 */
public interface GenericDAO<Integer, Item> {

    /**
     * Запрос всех данных.
     * @return 
     */
    List<Item> selectWithOffset();
    
    /**
     * Запрос данных ограниченного количества данных с сдвигом.
     * @param offset
     * @param limit
     * @return 
     */
    List<Item> selectWithOffset(int offset, int limit);
    
    /**
     * Получение объекта по ключу.
     * @param key
     * @return 
     */
    Item findByKey(Integer key);
    
    /**
        * Удаление объекта по ключу.
     * @param key
     * @return 
     */
    void removeByKey(Integer key);
    
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

    void create(Item item);
}
