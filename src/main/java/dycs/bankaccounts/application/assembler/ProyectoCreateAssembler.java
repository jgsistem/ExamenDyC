package dycs.bankaccounts.application.assembler;

import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import dycs.bankaccounts.application.dto.ProyectoCreateDto;
import dycs.bankaccounts.domain.entity.Proyecto;
import dycs.common.domain.valueobject.Money;
import dycs.common.domain.valueobject.MoneyAbstraction;
import dycs.common.infrastructure.persistence.hibernate.UnitOfWorkHibernate;
import dycs.customers.domain.entity.Cliente;

public class ProyectoCreateAssembler {
	@Autowired
	protected UnitOfWorkHibernate unitOfWork;
	
	public Proyecto toEntity(ProyectoCreateDto proyectoCreateDto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(getConverter());
		Proyecto proyecto = modelMapper.map(proyectoCreateDto, Proyecto.class);
		return proyecto;
	}
	
	public List<Proyecto> toEntityList(List<ProyectoCreateDto> proyectoCreateListDto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(getConverter());
		List<Proyecto> proyectoListDto = modelMapper.map(proyectoCreateListDto, new TypeToken<List<Proyecto>>() {}.getType());
		return proyectoListDto;
	}
	
	private Converter<ProyectoCreateDto, Proyecto> getConverter() {
		Converter<ProyectoCreateDto, Proyecto> converter = new Converter<ProyectoCreateDto, Proyecto>() {
		    @Override
		    public Proyecto convert(MappingContext<ProyectoCreateDto, Proyecto> context) {
		    	ProyectoCreateDto proyectoCreateDto =  ProyectoCreateDto.class.cast(context.getSource());
		    	MoneyAbstraction balance = new Money(proyectoCreateDto.getBalance(), proyectoCreateDto.getNumber());
		    	Proyecto proyecto = new Proyecto();
		    	//proyecto.setId(proyectoCreateDto.getId());
		    	proyecto.setPais(proyectoCreateDto.getPais());
		    	proyecto.setNumber(proyectoCreateDto.getNombre());
		    	proyecto.setBalance(balance);
		        Cliente cliente = new Cliente();
		        cliente.setId(proyectoCreateDto.getCliente_id());
		    	return proyecto;
		    }
		};
		return converter;
	}
	
	public ProyectoCreateDto toDto(Proyecto proyecto) {
		ModelMapper modelMapper = new ModelMapper();
		PropertyMap<Proyecto, ProyectoCreateDto> map = new PropertyMap<Proyecto, ProyectoCreateDto>() {
		  protected void configure() {
			map().setNumber(source.getNumber());
		    map().setBalance(source.getBalance().getAmount());
		   // map().setCurrency(source.getBalance().getCurrencyAsString());
		  //  map().setLocked(source.getIsLocked());
		   // map().setCustomerId(source.getCustomer().getId());
		  }
		};
		modelMapper.addMappings(map);
		ProyectoCreateDto proyectoCreateDto = modelMapper.map(proyecto, ProyectoCreateDto.class);
		return proyectoCreateDto;
	}
}