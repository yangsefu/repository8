package com.clive.service.impl;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.clive.bean.Items;
import com.clive.mapper.ItemsMapper;
import com.clive.service.ItemService;
import com.clive.utils.PictureUtils;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<Items> findItemsAll() {
		List<Items> list = itemsMapper.findItemsAll();
		return list;
	}
	@Override
	public Items findItemsById(Integer id) {
		Items items = itemsMapper.findItemsById(id);

		return items;
	}
	@Override
	public int updateitem(Items items,MultipartFile pictureFile) {
		Date date = new Date();
		items.setCreatetime(date);
		String name = pictureFile.getOriginalFilename();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String time = format.format(new Date());
		
		File file = new File("E://up",time);
		if(!file.exists()) {
			file.mkdir();
		}
		try {
			String imageNmae = PictureUtils.getImageNmae(name);
			pictureFile.transferTo(new File(file,imageNmae));
			items.setPic("http://localhost/"+time+"/"+imageNmae);
			int count = itemsMapper.updateitem(items);
			return count;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return 0;


	}

}
