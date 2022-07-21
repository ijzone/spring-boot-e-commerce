package com.ecommerce.product;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 상품 별 코드값 목록
 * @author Ikjoo Lee
 * @param label for view
 * @param code for product type classification
 * @param description
 * @param candidate for validation
 */
@Slf4j
@Getter
public enum ProductType {
	
	  ELECTRONICS("electronics", "P001", "electronics", "electronics")
	, FOOD("food", "P002", "food", "food")
	, ACCESSORIES("accessories", "P003", "accessories", "accessories")
	, FASHION("fashion", "P004", "fashion", "fashion")
	, SOFTWARE("software", "P005", "software", "software")
	, SPORTS("sports", "P006", "sports", "sports")
	;
	
	private String label;
	private String code;
	private String description;
	private String candidate;
	
	ProductType(String label, String code, String description, String candidate) {
		this.label = label;
		this.code = code;
		this.description = description;
		this.candidate = candidate;
	}
	
	public String getElectronicsLabel() {
		this.isApplicable(ELECTRONICS.getCandidate());
		return this.label;
	}
	
	public String getElectronicsCode() {
		this.isApplicable(ELECTRONICS.getCandidate());
		return this.code;
	}
	
	public String getFoodLabel() {
		this.isApplicable(FOOD.getCandidate());
		return this.label;
	}
	
	public String getFoodCode() {
		this.isApplicable(FOOD.getCandidate());
		return this.code;
	}
	
	public String getAccessoriesLabel() {
		this.isApplicable(ACCESSORIES.getCandidate());
		return this.label;
	}
	
	public String getAccessoriesCode() {
		this.isApplicable(ACCESSORIES.getCandidate());
		return this.code;
	}
	
	public String getFashionLabel() {
		this.isApplicable(FASHION.getCandidate());
		return this.label;
	}
	
	public String getFashionCode() {
		this.isApplicable(FASHION.getCandidate());
		return this.code;
	}
	
	public String getSoftwareLabel() {
		this.isApplicable(SOFTWARE.getCandidate());
		return this.label;
	}
	
	public String getSoftwareCode() {
		this.isApplicable(SOFTWARE.getCandidate());
		return this.code;
	}
	
	public String getSportsLabel() {
		this.isApplicable(SPORTS.getCandidate());
		return this.label;
	}
	
	public String getSportsCode() {
		this.isApplicable(SPORTS.getCandidate());
		return this.code;
	}
	
	private void isApplicable(String target) {
		if(!this.candidate.trim().toLowerCase().contains(target)) {
			throw new IllegalArgumentException("해당코드는" + target + "에 적용할 수 없는 코드 입니다.");
		}
	}
	
	public void printInfo() {
		log.info("ProductType label: {}", this.label);
		log.info("ProductType code: {}", this.code);
		log.info("ProductType description: {}", this.description);
		log.info("ProductType candidate: {}", this.candidate);
	}
}
