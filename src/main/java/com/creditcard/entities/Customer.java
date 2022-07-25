package com.creditcard.entities;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name ="Customer")
public class Customer {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.TABLE)
//	@GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@NotNull
	@NotBlank(message = "UserID must not be null..")
	private String userId;
	@NotNull
	@NotBlank(message = "UserID must not be null..")
	private String name;
	@Email
	private String email;
	@Size(min=10,max=10, message= "enter valid phone number")
	private String contactNo;
	
	private LocalDate dob;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="doorNo", column=@Column(name="Customer_doorno")),
		@AttributeOverride(name="street", column=@Column(name="Customer_street")),
		@AttributeOverride(name="area", column=@Column(name="Customer_area")),
		@AttributeOverride(name="city", column=@Column(name="Customer_city")),
		@AttributeOverride(name="state", column=@Column(name="Customer_state")),
		@AttributeOverride(name="pincode", column=@Column(name="pincode")),

	})
	private Address address;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<CreditCard> creditCard;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	
	private List<Transaction> transaction;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Statement> statement;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Account> account;

	@OneToOne(mappedBy = "customer")
	@JsonIgnore
	private User user;
	
	
}
