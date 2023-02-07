package model;

import java.util.ArrayList;
import java.util.List;

import database.ClientListDAO;
import database.ItemTableDAO;

public class UpdateSearchLogic {
	/**
	 * IDから商品情報を検索するmethod
	 * @param itemId 商品ID
	 * @return　商品情報
	 * @throws Exception
	 */
    public List<SearchResultBeans> searchName(String[] itemId) throws Exception{
    	
    	List<SearchResultBeans>itemList = new ArrayList<>();
    	
    	for(int i = 0; i < itemId.length; i++) {
    	
    		ItemTableDAO search = new ItemTableDAO(itemId[i]);
    		
    		itemList.add((SearchResultBeans)search.showTable());
    	}
    	
    	return itemList;
    }
    /**
     * 取引番号から取引情報を得るmethod
     * @param dealCode　取引番号
     * @return　取引先会社名
     * @throws Exception
     */
    public List<ClientBeans> searchClient(String []dealCode) throws Exception{
    	
    	List<ClientBeans> clientlist = new ArrayList<>();
    	
    	for(int i = 0; i < dealCode.length; i++) {
    	
    		ClientListDAO save = new ClientListDAO(dealCode[i]);
    		
    		clientlist.add((ClientBeans)save.showTable());
    		
    	}
    	
    		return clientlist;
    	
    }
}
