package br.com.threeway.locadora.converter;

import br.com.threeway.locadora.dao.TipoFilmeDao;
import br.com.threeway.locadora.domain.TipoFilme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.convert.FacesConverter;

@Component
@FacesConverter("tipoFilme")
public class TipoFilmeConverter extends EntityConverter<TipoFilme> {

	@Autowired
	public TipoFilmeConverter(TipoFilmeDao tipoFilmeDao){
		super(tipoFilmeDao);
	}

}
