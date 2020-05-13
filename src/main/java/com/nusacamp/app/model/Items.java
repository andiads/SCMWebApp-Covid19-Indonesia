package com.nusacamp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Items {
	
	
	private int id_item;
	
	private String item_code;
	private String item_name;
	private String item_brand;
	private String item_kemasan;
	private int item_pieces_kemasan;
	private String item_metrics_pieces;
	private int id_category;
	private String created_at;
	private String updated_at;
	private int shown;
	private int created_by;
	private int id_brand;
	private int id_sub_cat;
	private int id_distributor;
	private int id_metrics;

	
	public Items() {
	
	}
	
	
	protected Items(int id_item, String item_code, String item_name, String item_brand, String item_kemasan,
			int item_pieces_kemasan, String item_metrics_pieces, int id_category, String created_at, String updated_at,
			int shown, int created_by, int id_brand, int id_sub_cat, int id_distributor, int id_metrics) {
		super();
		this.id_item = id_item;
		this.item_code = item_code;
		this.item_name = item_name;
		this.item_brand = item_brand;
		this.item_kemasan = item_kemasan;
		this.item_pieces_kemasan = item_pieces_kemasan;
		this.item_metrics_pieces = item_metrics_pieces;
		this.id_category = id_category;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.shown = shown;
		this.created_by = created_by;
		this.id_brand = id_brand;
		this.id_sub_cat = id_sub_cat;
		this.id_distributor = id_distributor;
		this.id_metrics = id_metrics;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId_item() {
		return id_item;
	}
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_brand() {
		return item_brand;
	}
	public void setItem_brand(String item_brand) {
		this.item_brand = item_brand;
	}
	public String getItem_kemasan() {
		return item_kemasan;
	}
	public void setItem_kemasan(String item_kemasan) {
		this.item_kemasan = item_kemasan;
	}
	public int getItem_pieces_kemasan() {
		return item_pieces_kemasan;
	}
	public void setItem_pieces_kemasan(int item_pieces_kemasan) {
		this.item_pieces_kemasan = item_pieces_kemasan;
	}
	public String getItem_metrics_pieces() {
		return item_metrics_pieces;
	}
	public void setItem_metrics_pieces(String item_metrics_pieces) {
		this.item_metrics_pieces = item_metrics_pieces;
	}
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public int getShown() {
		return shown;
	}
	public void setShown(int shown) {
		this.shown = shown;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public int getId_brand() {
		return id_brand;
	}
	public void setId_brand(int id_brand) {
		this.id_brand = id_brand;
	}
	public int getId_sub_cat() {
		return id_sub_cat;
	}
	public void setId_sub_cat(int id_sub_cat) {
		this.id_sub_cat = id_sub_cat;
	}
	public int getId_distributor() {
		return id_distributor;
	}
	public void setId_distributor(int id_distributor) {
		this.id_distributor = id_distributor;
	}
	public int getId_metrics() {
		return id_metrics;
	}
	public void setId_metrics(int id_metrics) {
		this.id_metrics = id_metrics;
	}
	
	
}
