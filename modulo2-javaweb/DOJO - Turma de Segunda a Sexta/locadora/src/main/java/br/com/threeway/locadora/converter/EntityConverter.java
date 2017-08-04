package br.com.threeway.locadora.converter;

import br.com.threeway.locadora.domain.Entity;
import br.com.threeway.locadora.service.TipoFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


public abstract class EntityConverter<T extends Entity> implements Converter {

	private JpaRepository<T, Long> dao;

	public EntityConverter(JpaRepository<T, Long> dao) {
		this.dao = dao;
	}

	@Override
	public T getAsObject(FacesContext context, UIComponent component, String value) {
		Long id = Long.valueOf(value);
		return dao.findOne(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((Entity)value).getId().toString();
	}
}
