package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {
	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false,length = 40)

	private String Name;
	@Column(nullable = false,length = 40)

	private String rib;
	@Column(nullable = false,length = 40)

	private double amount;
	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Operation.class)
	private Operation operation;

	
}
