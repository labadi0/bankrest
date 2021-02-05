package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Operation {
		@Id 
		@GeneratedValue (strategy = GenerationType.AUTO)
		private int id;
		@Column(nullable = false,length = 40)
		private String operationName;
		
}
