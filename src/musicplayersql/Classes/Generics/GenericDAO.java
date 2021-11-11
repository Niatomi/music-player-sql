/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayersql.Classes.Generics;

import java.util.List;

/**
 *
 * @author Niatomi
 */
public interface GenericDAO<Key, Item> {
    
    /**
     * Создание базы данных.
     * @return 
     */
    void create();
    
    /**
     * Создание базы данных.
     * @return 
     */
    void drop();
    
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
    boolean removeByKey(Key key);
    
    /**
     * Добавление объекта.
     * @param item
     * @return 
     */
    boolean insert(Item item);
    
    /**
     * Обновление объекта.
     * @param item
     * @return 
     */
    boolean update(Integer key, Item item);
}
