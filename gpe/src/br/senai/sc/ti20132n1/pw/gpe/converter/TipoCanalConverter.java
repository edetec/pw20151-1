package br.senai.sc.ti20132n1.pw.gpe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.ti20132n1.pw.gpe.dao.TipoCanalDao;
import br.senai.sc.ti20132n1.pw.gpe.entity.TipoCanal;

@FacesConverter(forClass=TipoCanal.class)
public class TipoCanalConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
		TipoCanalDao dao = new TipoCanalDao();
		Long id = Long.valueOf(value);
		return dao.buscaPorId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uiComponent, Object value) {
		TipoCanal tipoCanal = (TipoCanal) value;
		return tipoCanal.getId().toString();
	}

}
