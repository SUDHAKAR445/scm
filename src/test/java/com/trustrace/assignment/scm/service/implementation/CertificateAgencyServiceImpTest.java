package com.trustrace.assignment.scm.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.trustrace.assignment.scm.exception.MyNotFoundException;
import com.trustrace.assignment.scm.model.CertificateAgency;
import com.trustrace.assignment.scm.repository.CertificateAgencyRepository;

@ExtendWith(MockitoExtension.class)
public class CertificateAgencyServiceImpTest {

    @Mock
    private CertificateAgencyRepository certificateAgencyRepository;

    @InjectMocks
    private CertificateAgencyServiceImp certificateAgencyService;

    @Test
    public void agencyCreated() throws Exception{
        CertificateAgency c=new CertificateAgency("683764","mnvbdk","bjakjs","baui","jhhan","ukna");
        Mockito.when(certificateAgencyRepository.save(c)).thenReturn(c);
        CertificateAgency result = certificateAgencyService.saveAgency(c);
        assertEquals(c, result);
    }

    @Test
    public void agencyNotCreated() throws Exception{
        CertificateAgency c=new CertificateAgency("683764","mnvbdk","bjakjs","baui","jhhan","ukna");
        Mockito.when(certificateAgencyRepository.save(c)).thenThrow(RuntimeException.class);
        CertificateAgency result = certificateAgencyService.saveAgency(c);
        assertNotEquals(c, result);
    }

    @Test
    public void getById() throws Exception{
        
        String agencyId = "AGY001";
        Optional<CertificateAgency> expectedAgency =Optional.of(new CertificateAgency());
        Mockito.when(certificateAgencyRepository.findById(agencyId)).thenReturn(expectedAgency);
        Optional<CertificateAgency> result = certificateAgencyService.getById(agencyId);

        assertEquals(expectedAgency, result);
    }

    @Test
    public void testGetAllAgencies() {

        CertificateAgency agency1 = new CertificateAgency("683764","mnvbdk","bjakjs","baui","jhhan","ukna");
        CertificateAgency agency2 = new CertificateAgency("683764","mnvbdk","bjakjs","baui","jhhan","ukna");

        List<CertificateAgency> expectedAgencies = Arrays.asList(agency1, agency2);

        Mockito.when(certificateAgencyRepository.findAll()).thenReturn(expectedAgencies);
        List<CertificateAgency> result = certificateAgencyService.getAllAgency();
        assertEquals(expectedAgencies.size(), result.size());
        assertEquals(expectedAgencies, result);
        verify(certificateAgencyRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateAgencyExisting() {
        String agencyId = "AGY001";
        CertificateAgency existingAgency = new CertificateAgency("683764","mnvbdk","bjakjs","baui","jhhan","ukna");
        CertificateAgency updatedAgency = new CertificateAgency("683764","mnvbdk","bjakjs","baui","jhhan","ukna");

        when(certificateAgencyRepository.findById(agencyId)).thenReturn(Optional.of(existingAgency));
        when(certificateAgencyRepository.save(existingAgency)).thenReturn(updatedAgency);

        CertificateAgency result = certificateAgencyService.updateAgency(updatedAgency);

        assertEquals(updatedAgency.getName(), result.getName());
        verify(certificateAgencyRepository, times(1)).findById(agencyId);
        verify(certificateAgencyRepository, times(1)).save(existingAgency);
    }
    @Test
    public void testDeleteAgencyExisting() 
    {
        String agencyId = "AGY001";
        Mockito.when(certificateAgencyRepository.findById(agencyId)).thenReturn(Optional.of(new CertificateAgency()));
        certificateAgencyService.deleteAgency(agencyId);
        verify(certificateAgencyRepository, times(1)).deleteById(agencyId);
    }

    @Test
    public void testDeleteAgencyNotFound() {
        // Arrange
        String agencyId = "AGY001";
        when(certificateAgencyRepository.findById(agencyId)).thenReturn(Optional.empty());

        // Act and Assert
        MyNotFoundException exception = assertThrows(MyNotFoundException.class, () -> certificateAgencyService.deleteAgency(agencyId));
        assertEquals("Agency not found", exception.getMessage());
    }
}