package com.example.hospitalMT.model;
import jakarta.persistence.*;

@Entity
@Table(name="medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="drug_name")
    private String drugname;
    private String stock;
	public Medicine(Long id, String drugname, String stock) {
		super();
		this.id = id;
		this.drugname = drugname;
		this.stock = stock;
	}
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDrugname() {
		return drugname;
	}
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}

	
    
}
