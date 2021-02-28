package servicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

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

import dao.ConsultationDao;
import dao.TransferDao;
import entity.Consultation;
import entity.Transfer;
import services.ConsultationService;
import services.TransferService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ConsultationServiceTest {
	
	@Mock
	private ConsultationDao consultationDao;

	@Captor
	private ArgumentCaptor<Transfer> postArgumentCaptor;

	@Test
	@DisplayName("je test si la method saveConsultation foncionne ")
	public void saveConsultationTest() {
		
		ConsultationService consultationService = new ConsultationService();
		consultationService.setConsultationDao(consultationDao);
		Consultation consultation = new Consultation(1, 100);
		/*
		postService.saveTransfer(postRequest);
		Mockito.verify(userRepository, Mockito.times(1)).save(postArgumentCaptor.capture());

		Assertions.assertThat(postArgumentCaptor.getValue().getId()).isEqualTo(1);
		Assertions.assertThat(postArgumentCaptor.getValue().getMoneyTransfer()).isEqualTo(200);
		*/
		Mockito.when(consultationDao.save(consultation)).thenReturn(consultation);
        Consultation found = consultationService.saveConsultation(consultation);

        assertNotNull(found);
        assertEquals(consultation.getId(), found.getId());
        assertEquals(consultation.getNumberConsultation(), found.getNumberConsultation());

	}
	
	
	

	
	
	/*
	@Test
	@DisplayName("je test si la method updateTransfer foncionne ")
	public void UpdateTransferTest() throws Exception{
		
		TransferService postService = new TransferService();
		postService.setTransferDao(userRepository);
		Optional<Transfer> postRequest = Optional.of(new Transfer(1, 200));
		
		Transfer postRequest2 = new Transfer(1,100);
		
		
		Mockito.when(userRepository.save(postRequest.get())).thenReturn(postRequest.get());
		Mockito.when(userRepository.findById(1)).thenReturn(postRequest);

		Mockito.when(userRepository.save(postRequest2)).thenReturn(postRequest2);

        Transfer found = postService.saveTransfer(postRequest.get());
            
        Transfer found2 = postService.saveTransfer(postRequest2);


        assertNotNull(found2);
        assertEquals(found.getId(), found2.getId());
        
       // assertEquals(100, found.getMoneyTransfer());

	}
	*/

	@Test
	@DisplayName("ici je teste si la methode deleteConsultation marche ou pas ")
	public void deleteConsultationTest() {
		ConsultationService consultationService = new ConsultationService();
		consultationService.setConsultationDao(consultationDao);
		Consultation consultation = new Consultation(1, 200);
		// when(userRepository.deleteById(1)).thenReturn(transferEntity);

		consultationService.deleteConsultation(consultation.getId());

        Mockito.verify(consultationDao, Mockito.times(1)).deleteById(consultation.getId());

	}

	@Test
	@DisplayName("ici je teste si la methode getTransfer marche ou pas ")
	public void getConsultationTest() {
		ConsultationService consultationService = new ConsultationService();
		consultationService.setConsultationDao(consultationDao);
		
		
		Optional<Consultation> consultation = Optional.of(new Consultation(1, 200));
		when(consultationDao.findById(1)).thenReturn(consultation);

		Consultation tf = consultationService.getConsultationById(1);
		assertEquals(200, tf.getNumberConsultation());
	}

	
	
	
	
	
	
	
	
	

}
