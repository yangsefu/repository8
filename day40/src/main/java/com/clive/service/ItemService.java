package com.clive.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.clive.bean.Items;

public interface ItemService {
	List<Items> findItemsAll();

	Items findItemsById(Integer id);

	int updateitem(Items items, MultipartFile pictureFile);
}
