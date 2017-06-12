package con.brq.jchaves.middleware.watson.serviceinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import con.brq.jchaves.middleware.watson.service.DocumentService;

@RestController
@RequestMapping("/documentServiceInterface")
public class DocumentServiceInterface {

	@Autowired
	private DocumentService documentService;

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String retrieveProperlyDocumentbasedOnKeyword(
			@RequestParam(value = "keyword", required = true) String keyword) throws Exception {
		String result = documentService.retrieveProperlyDocumentbasedOnKeyword(keyword);
		return result;
	}

}
