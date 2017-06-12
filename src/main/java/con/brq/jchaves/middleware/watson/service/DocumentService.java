package con.brq.jchaves.middleware.watson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import con.brq.jchaves.middleware.watson.dao.DocumentDAO;

@Service
public class DocumentService {
	
	@Autowired
	private DocumentDAO documentDAO;

	public String retrieveProperlyDocumentbasedOnKeyword(String keyword) {

		
		
		return null;
	}

}
