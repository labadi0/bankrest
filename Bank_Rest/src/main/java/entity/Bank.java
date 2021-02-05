package entity;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idBank;
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Client.class)
	private ArrayList<Client> clients = new ArrayList<Client>();
	@Column(nullable = false,length = 40)
	private String bankName;
}
