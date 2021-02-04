package com.clive.mapper;

import java.util.List;

import com.clive.bean.Items;

public interface ItemsMapper {
	List<Items> findItemsAll();

	Items findItemsById(Integer id);

	int updateitem(Items items);

	
}
