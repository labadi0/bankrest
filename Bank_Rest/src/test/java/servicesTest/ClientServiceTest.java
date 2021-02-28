package servicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

import dao.ClientDao;
import dao.ConsultationDao;
import entity.Client;
import entity.Consultation;
import entity.Transfer;
import services.ClientService;
import services.ConsultationService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ClientServiceTest {
	
	@Mock
	private ClientDao clientDao;

	@Captor
	private ArgumentCaptor<Transfer> postArgumentCaptor;

	@Test
	@DisplayName("je test si la method saveClient foncionne ")
	public void saveClientTest() {
		
		ClientService clientService = new ClientService();
		clientService.setClientDao(clientDao);
		Client client = new Client(1, "client1", "12AEZR1A", 200, new Transfer(1, 200));
		/*
		postService.saveTransfer(postRequest);
		Mockito.verify(userRepository, Mockito.times(1)).save(postArgumentCaptor.capture());

		Assertions.assertThat(postArgumentCaptor.getValue().getId()).isEqualTo(1);
		Assertions.assertThat(postArgumentCaptor.getValue().getMoneyTransfer()).isEqualTo(200);
		*/
		Mockito.when(clientDao.save(client)).thenReturn(client);
        Client found = clientService.saveClient(client);

        assertNotNull(found);
        assertEquals(client.getId(), found.getId());
        assertEquals(client.getName(), found.getName());

	}
	

	@Test
	@DisplayName("ici je teste si la methode deleteClient marche ou pas ")
	public void deleteClientTest() {
		ClientService clientService = new ClientService();
		clientService.setClientDao(clientDao);
		Client client = new Client(1, "client1", "12AEZR1A", 200, new Transfer(1, 200));
		// when(userRepository.deleteById(1)).thenReturn(transferEntity);

		clientService.deleteClient(client.getId());

        Mockito.verify(clientDao, Mockito.times(1)).deleteById(client.getId());

	}

	
	

}
