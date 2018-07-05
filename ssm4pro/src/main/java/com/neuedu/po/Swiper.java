package com.neuedu.po;
import org.apache.ibatis.type.Alias;

@Alias("Swiper")
public class Swiper {

	private int id;
	private int qid;
	private String imgurl;
	private String category;
	
	public String toString() {
		return  id + "_" + qid + "_" + imgurl + "_" + category;
	}
	
	public boolean equals(Swiper swiper) {
		boolean flag = true;
		if (id != swiper.id) flag= false;
		if (qid != swiper.qid) flag= false;
		if (!imgurl.equals(swiper.imgurl)) flag=false ;
		if (!category.equals(swiper.category)) flag=false ;
		return flag;
	}
		
		
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
