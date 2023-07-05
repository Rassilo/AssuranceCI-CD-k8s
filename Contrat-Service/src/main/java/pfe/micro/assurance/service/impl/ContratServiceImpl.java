package pfe.micro.assurance.service.impl;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import pfe.micro.assurance.entity.Contrat;
import pfe.micro.assurance.repository.ContratRepository;
import pfe.micro.assurance.service.ContratService;

@Service
public class ContratServiceImpl implements ContratService{
	
	@Autowired
	private ContratRepository contratRepository;

	
	@Override
	public Contrat ajouterContrat(MultipartFile file,Integer souscriptionId) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		boolean etat = true  ;
		Contrat contrat = new Contrat(fileName, file.getContentType(), file.getBytes(),etat,souscriptionId);
		return contratRepository.save(contrat);
	}

	@Override
	public Contrat getContrat(Integer contratId) {
		
		return contratRepository.findById(contratId).get();
	}

	@Override
	public Stream<Contrat> getAllContrat() {
		return contratRepository.findAll().stream();
	}

	@Override
	public Contrat updateContrat(Contrat contrat) {
		
		return contratRepository.save(contrat);
	}
	
	@Override
	public Contrat updateEtat(Integer contratId,boolean etat) {
		Contrat contrat = contratRepository.findById(contratId).get();
		contrat.setEtat(etat);
		return contratRepository.save(contrat);
	}

	@Override
	public Stream<Contrat> getBySouscriptionId(Integer souscriptionId) {
		return contratRepository.findBySouscriptionId(souscriptionId).stream();
	}
}