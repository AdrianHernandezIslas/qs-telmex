package com.telmex.demo.service.implement;

import java.io.InputStream;
import java.util.List;

import com.telmex.demo.service.ComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telmex.demo.entity.Comision;
import com.telmex.demo.entity.Promotor;
import com.telmex.demo.model.Chargeback;
import com.telmex.demo.repository.ComisionRepository;
import com.telmex.demo.repository.PromotorRepository;
import com.telmex.demo.utils.Excel;
import com.telmex.demo.utils.Sftp;

@Service
public class ComisionServiceImpl implements ComisionService {
	
	@Autowired
	private ComisionRepository comRepo;
	
	@Autowired
	private PromotorRepository proRepo;

	public void getFileFTP(String nameFile) throws Exception {
		Sftp ftp = new Sftp();
		InputStream inStr = ftp.getFile(nameFile);
		System.out.println("Archivo leído del FTP correctamente: "+nameFile);
		
		Excel exc = new Excel();
		List<Chargeback> rows = exc.readFile(inStr);
		System.out.println("Archivo excel leído correctamente: "+nameFile+" total: "+rows.size());
		ftp.disconect();
		
		for(Chargeback c : rows) {
			Promotor promo = new Promotor();
			promo.setClave(c.getClave());
			promo.setNombre(c.getNombrePromotor());
			proRepo.save(promo);
			
			Comision com = new Comision();
			com.setAnticipo(c.getAnticipo());
			com.setMontoDescuento(c.getMontoDescuento());
			com.setPromotor(promo);
			
			comRepo.save(com);
		}
		
	}
}
