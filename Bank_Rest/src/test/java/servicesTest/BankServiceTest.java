package servicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import dao.BankDao;
import dao.ClientDao;
import entity.Bank;
import entity.Client;
import entity.Transfer;
import services.BankService;
import services.ClientService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BankServiceTest {
	@Mock
	private BankDao bankDao;

	@Captor
	private ArgumentCaptor<Transfer> postArgumentCaptor;
	
	@Test
	@DisplayName("je test si la method saveBank foncionne ")
	public void saveBankTest() {
		
		BankService bankService = new BankService();
		bankService.setBankDao(bankDao);
		Client client = new Client(1, "client1", "12AEZR1A", 200, new Transfer(1, 200));
		ArrayList<Client> clients = new ArrayList<Client>();
		clients.add(client);	
		Bank bank = new Bank(1, clients, "axa Banque");
		
		
		/*
		postService.saveTransfer(postRequest);
		Mockito.verify(userRepository, Mockito.times(1)).save(postArgumentCaptor.capture());

		Assertions.assertThat(postArgumentCaptor.getValue().getId()).isEqualTo(1);
		Assertions.assertThat(postArgumentCaptor.getValue().getMoneyTransfer()).isEqualTo(200);
		*/
		Mockito.when(bankDao.save(bank)).thenReturn(bank);
        Bank found = bankService.saveBank(bank);

        assertNotNull(found);
        assertEquals(bank.getIdBank(), found.getIdBank());
        assertEquals(bank.getBankName(), found.getBankName());

	}
	
	
	@Test
	@DisplayName("ici je teste si la methode deleteBank marche ou pas ")
	public void deleteClientTest() {
		BankService bankService = new BankService();
		bankService.setBankDao(bankDao);
		Client client = new Client(1, "client1", "12AEZR1A", 200, new Transfer(1, 200));
		ArrayList<Client> clients = new ArrayList<Client>();
		clients.add(client);	
		Bank bank = new Bank(1, clients, "axa Banque");
		// when(userRepository.deleteById(1)).thenReturn(transferEntity);

		bankService.deleteBank(bank.getIdBank());

        Mockito.verify(bankDao, Mockito.times(1)).deleteById(bank.getIdBank());

	}

	
	
	
	@Test
	@DisplayName("ici je teste si la methode getClient marche ou pas ")
	public void getClientTest() {
		BankService bankService = new BankService();
		bankService.setBankDao(bankDao);
		Client client = new Client(1, "client1", "12AEZR1A", 200, new Transfer(1, 200));
		ArrayList<Client> clients = new ArrayList<Client>();
		clients.add(client);	
		Optional<Bank> bank = Optional.of(new Bank(1, clients, "axa Banque"));	
		when(bankDao.findById(1)).thenReturn(bank);
		Bank tf = bankService.getBankById(1);
		assertEquals(1, tf.getIdBank());
	}

	
	
	

	
	
}
