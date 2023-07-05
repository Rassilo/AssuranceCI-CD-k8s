package pfe.micro.assurance.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pfe.micro.assurance.entity.Contrat;

@Service
public interface ContratService {
	
Contrat ajouterContrat(MultipartFile file,Integer souscriptionId) throws IOException;
	
	Contrat getContrat(Integer contratId);
	
	Stream<Contrat> getBySouscriptionId(Integer souscriptionId);
	Stream<Contrat> getAllContrat();
	
	Contrat updateContrat(Contrat contrat);
	Contrat updateEtat(Integer contratId,boolean etat);

}
